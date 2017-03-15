import java.io.*;

public class Decrypt extends FileInputStream {

	public Decrypt(String name) throws FileNotFoundException {
		super(name);
	}

	public int read() throws IOException {
		int value = super.read();
		if (value == -1)
			return -1;
		value = value ^ 128;
		return value;
	}
}