import java.io.*;

public class Encrypt extends FileOutputStream {

	public Encrypt(String name) throws FileNotFoundException {
		super(name);
	}

	public void write(int value) throws IOException {
		value = value ^ 128;
		super.write(value);
	}
}