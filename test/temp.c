​​​​​
#include<RS232.h>

#define CLI() asm("cli \n");         /*Clear I Bit in CCR enables interrupts*/
// initializing the vector table
void porth_isr(void);

/*interrupt pragma*/
#pragma interrupt_handler porth_isr

/*initialize vector table with interrupt source address - PORTH_ INTERRUPT*/
#pragma abs_address: 0x3E4C
void (*PORTH_interrupt_vector[])()= {porth_isr };
#pragma end_abs_address

	int which_key(void) {
		int X;
		while (1) {
			PORTA = 0XFE; // Col 0 –PA0
			X = PORTA;
			if (X == 0xEE)
				return 0x01;
			if (X == 0xDE)
				return 0x04;
			if (X == 0xBE)
				return 0x07;
			if (X == 0x7E)
				return 0x0E;
			PORTA = 0XFD; //Col 1 – PA1
			X = PORTA;
			if (X == 0xED)
				return 0x02;
			if (X == 0xDD)
				return 0x05;
			if (X == 0xBD)
				return 0x08;
			if (X == 0x7D)
				return 0x00;
			PORTA = 0XFB;
			X = PORTA;
			if (X == 0xEB)
				return 0x03;
			if (X == 0xDB)
				return 0x06;
			if (X == 0xBB)
				return 0x09;
			if (X == 0x7B)
				return 0x0F;
			PORTA = 0XF7;
			X = PORTA;
			if (X == 0xE7)
				return 0x0A;
			if (X == 0xD7)
				return 0x0B;
			if (X == 0xB7)
				return 0x0C;
			if (X == 0x77)
				return 0x0D;
		}
	}
// =================================================================
// ==============================SPI================================
// =================================================================
#define DAC_CS 0x40
	void initDAC(void) {
		DDRM |= DAC_CS;	// Set PM6/CS to output
		PTM |= DAC_CS;	// Set CS to high to disable the data transmitting
		SPI0Setup();	// Setup SPI0 with 12 MHz baud rate
	}
	void SPI0Setup() {
		// Enable SPI0, Set Master Mode
		SPI0CR1 = 0x50;
		SPI0CR2 = 0x02;
		// Set Baud Rate register
		SPI0BR = 0x21;
	}

// =====================================================
// Send data to DAC through SPI0
// =====================================================
#define SPTEF 0x20
#define SPIF  0x80

	void Putchar_SPI0(char c) {
		char temp;
		while (!(SPI0SR & SPTEF))
			; /* wait until write is permissible */
		SPI0DR = c; /* output the byte to the SPI */
		while (!(SPI0SR & SPIF))
			; /* wait until write operation is complete */
		temp = SPI0DR; /* clear the SPIF flag */
	}
// =====================================================
// Write a 10 bit data to the DAC
// 0= Channel A, 1=Channel B
// =====================================================
#define DACA     0x00
#define DACB     0x01
#define USE_DACA 0x90
#define USE_DACB 0xA0
	void WriteDAC(int channel, int data) {
		// The output data to DAC is 16 bits:
		// A3|A2|A1|A0|D9|D8|D7|D6 D5|D4|D3|D2|D1|D0|xx|xx; xx= Don't care
		// A3-A0=Command 0x90=Load DAC A, 0xA0=Load DAC B

		// A3-A0 ... Channel Choice
		int outData;
		if (channel == DACA)
			outData = USE_DACA;
		else
			outData = USE_DACB;

		// D6-D9 ... higher 4 bits
		data = data >> 6;
		outData |= (data & 0x0F);

		PTM &= ~DAC_CS;	 // Enable the chip

		Putchar_SPI0(outData);    	// Write the command and upper 4 bits;
		outData = (data << 2) & 0xFC; // D0-D5 ... lower 6 bits
		Putchar_SPI0(outData);   	// Write the remainning 6 bits

		PTM |= DAC_CS;	 // disable the DAC
	}
// ===========================================================================
// ==================================SPI end==================================
// ===========================================================================

	void enable_int(void) {
		CLI()
		; /*Turn interrupt system on*/
	}

	char* vout, buffer[17], buffer2[50];
	int* status;
	float temp, hr, tempReading;
	int hrReading;

	void led_up(int num) {
		int i;
		for (i = 0; i < num; i++) {
			PORTB |= 1 >> i;
			delay_20msec();
		}
	}

	void led_down(int num) {
		int i;
		for (i = 0; i < num; i++) {
			PORTB = 0 << i;
			delay_20msec();
		}
	}

	void porth_isr(void) {
		int dig1, dig2, dig3, num;

		while (!(PIFH & 0x0F))
			;
		{
			clr_disp();
			if (PIFH & 0x01) {
				lcd_print_txt("Enter hr", LINE1);
				dig1 = which_key();
				delay_05sec();
				dig2 = which_key();
				delay_05sec();
				dig3 = which_key();
				delay_05sec();
				num = dig1 * 100 + dig2 * 10 + dig3;
				hr = num;
				clr_disp();
				sprintf(buffer, "Heart Rate: %d", num);
				lcd_print_txt(buffer, LINE1);
				delay_05sec();
			} else if (PIFH & 0x02) {
				lcd_print_txt("Enter temp", LINE1);
				dig1 = which_key();
				delay_05sec();
				dig2 = which_key();
				delay_05sec();
				dig3 = which_key();
				delay_05sec();
				num = dig1 * 100 + dig2 * 10 + dig3;
				temp = num;
				clr_disp();
				sprintf(buffer, "Temperature: %d", num);
				lcd_print_txt(buffer, LINE1);
				delay_05sec();
			} else if (PIFH & 0x04) {
				vout = ftoa(tempReading, status);
				vout[5] = '\0';
				sprintf(buffer2, "\r\nHeart Rate: %d\r\nTemperature: %s",
						hrReading, vout);
				Transmit_SCI0(buffer2);
			}
		}
		clr_disp();
		PIFH |= 0x0F;
	}

	void initialize_ADC() {
		ATD0CTL2 = 0X80;
		delay_5msec();
		ATD0CTL3 = 0X00;
		ATD0CTL4 = 0X85;
	}

	void buzzer(int time) {
		int i;
		for (i = 0; i < time; i++) { //buzzer
			PTT = 0x20;
			delay_1msec();
			PTT = 0x00;
			delay_1msec();
			delay_1msec();
		}
	}

	void vibrate() {
		//PTJ = 0xFF; //disable led
		PORTB = 0x01; //motor on
		delay_20msec();
		PORTB = 0x00; // motor off
		delay_20msec();
		//PTJ = 0x00;// led enable
	}

	void generate() {
		double bps = hrReading / 60;
		int WaveCntr = 0;
		int skipcount = 2;
		initDAC();
		while (1) {
			WriteDAC(DACA, WaveCntr);
			WaveCntr += skipcount;
		}
	}

	void main(void) {
		SCI0Setup(9600);
		DDRH = 0x00;
		DDRB = DDRJ = DDRP = 0xFF;
		PTJ = 0x00;
		PPSH &= 0xF0; //porth pull polarity select
		PIEH |= 0x0F; //set porth interrupt enable register
		PIFH |= 0x0F; //clear porth interrupt flag register
		DDRB = 0xFF; //humidifier motor 0 and 1
		DDRM = 0xFF; //alpha num data PM6-0
		DDRP = 0xFF; //alpha num addr PP3-2
		DDRE = 0xFF; //cooling fan PE2
		DDRT = 0xFF; //buzzer
		DDRA = 0x0F;
		PUCR = 0xFF;
		PTP = 0x01;
		PORTE = 0xFF;
		init_lcd();
		initialize_ADC();

		enable_int();
		temp = 25;
		hr = 150;
		while (1) {
			clr_disp();
			ATD0CTL5 = 0XB5;
			tempReading = ATD0DR0;
			tempReading = tempReading * 0.02 * 100;
			hrReading = ATD0DR2;
			sprintf(buffer, "%d bpm", hrReading);
			lcd_print_txt(buffer, LINE1);
			vout = ftoa(tempReading, status);
			vout[5] = '\0';
			sprintf(buffer, "%s C", vout);
			lcd_print_txt(buffer, LINE2);
			if (hrReading > hr || tempReading > temp) {
				vibrate();
				PORTB = 0xC0;
				if (hrReading > hr + 10) {
					PORTB = 0xF0;
					buzzer(100);
					vibrate();
					PTJ = 0x00; // led enable
					if (hrReading > hr + 30) {
						PORTB = 0xFC;
						buzzer(100);
						vibrate();
					}
				}
			} else {
				PTJ = 0xFF;
				PORTB = 0x00;
				PTJ = 0x00;
			}
			delay_05sec();
		}
	}
