import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class driver {

	private int distance;
	private int range;
	private SerialPort serialPort;

	public driver(String portName) {
		serialPort = new SerialPort(portName);
	}

	public void openPort() {
		try {
			serialPort.openPort();
			serialPort.setParams(9600, 8, 1, 0);

		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

	public void closePort() {
		try {
			serialPort.closePort();

		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

	public void getvalues() {
		try {
			byte[] data = serialPort.readBytes(3);
			range = (int) (data[0] | data[1] << 8);
			distance = (int) data[2];
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

	public double getDistance() {
		return distance * 3.14 * 14.2 / 5;
	}

	public int getRange() {
		return range;
	}

	public boolean isStopped() {
		getvalues();
		while (range < 0) {
			getvalues();
		}
		return true;
	}

	public void setOnTime(int onTime) {
		try {
			serialPort.writeInt(onTime);

		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

}
