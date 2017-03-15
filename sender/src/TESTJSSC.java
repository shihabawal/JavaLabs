import jssc.SerialPort;

import jssc.SerialPortException;
import jssc.SerialPortList;

public class TESTJSSC {
	public static void main(String[] args) throws SerialPortException {
		SerialPort serialPort = new SerialPort("/dev/ttyUSB0");
		try {
			serialPort.openPort();// Open serial port
			serialPort.setParams(9600, 8, 1, 0);// Set params.
			if (serialPort.writeByte((byte) 2))
				System.out.println("Sent 4");
			while (true) {
				// byte[] buffer = serialPort.readBytes(2);//Read 10 bytes from
				// serial port
				// String s = serialPort.readString(10);
				// System.out.print(new String(s));
				// System.out.println((int)buffer[0] + " " + (int)buffer[1]);
				byte[] data = serialPort.readBytes(3);
				int range = (int) (data[0] | data[1] << 8);
				int count = (int) data[2];
				if (range > 0)
					System.out.println(range + "[0] " + count + "[1]");
				
			}
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
		serialPort.closePort();// Close serial port
	}
}