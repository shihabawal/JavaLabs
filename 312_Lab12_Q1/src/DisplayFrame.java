import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class DisplayFrame extends JFrame implements ActionListener, Observer, Runnable {

	JLabel devIDL, aceleL, sensorL;
	JTextField devIDT, aceleT, sensorT, text;

	DisplayFrame() {
		setTitle("Observer");
		setLayout(new GridLayout(3, 2));
		setSize(600, 200);
		
		devIDL = new JLabel("Device ID info:");
		aceleL = new JLabel("Acelerometer info:");
		sensorL = new JLabel("Sensor info:");
		
		devIDT = new JTextField();
		devIDT.setText("");
		aceleT = new JTextField();
		aceleT.setText("");
		sensorT = new JTextField();
		sensorT.setText("");
		
		add(devIDL);
		add(devIDT);
		add(aceleL);
		add(aceleT);
		add(sensorL);
		add(sensorT);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	}

	@Override
	public void update(int x) {
		synchronized (this) {
			int devid = (x>>5) & 0x00000007;
			int aceleinfo = (x>>2) & 0x00000007; 
			int sensorinfo = x & 0x00000003;
			
			devIDT.setText("End device " + (devid+1));
			
			switch (aceleinfo){
			case 0:
				aceleT.setText("x axis acceleration has crossed limits (0.5g)");break;
			case 1:
				aceleT.setText("x axis acceleration has crossed limits (-0.5g)");break;
			case 2:
				aceleT.setText("y axis acceleration has crossed limits (0.5g)");break;
			case 3:
				aceleT.setText("y axis acceleration has crossed limits (-0.5g)");break;
			case 4:
				aceleT.setText("z axis acceleration has crossed limits (0.5g)");break;
			case 5:
				aceleT.setText("z axis acceleration has crossed limits (-0.5g)");break;
			case 6:
				aceleT.setText("Total acceleration has crossed limits (0.8 g)");break;
			case 7:
				aceleT.setText("No acceleration(at Rest)");break;
			}
			
			switch (sensorinfo){
			case 0:
				sensorT.setText("Temperature has crossed limit (400 C)");break;	
			case 1:
				sensorT.setText("Light has crossed limits bright ((Dark, Normal, Bright)");break;	
			case 2:
				sensorT.setText("Pressure sensor has crossed limit(Low, Norma, High)");break;	
			case 3:
				sensorT.setText("Any other sensor crosses the limit");break;				
			}
		}

	}

	@Override
	public void run() {
		Thread t = new Thread(this, "Display Frame");
		t.start();
	}

}