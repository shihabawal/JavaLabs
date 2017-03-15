import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CovertToLowerCase {
	private DataInputStream in;

	public CovertToLowerCase(InputStream in) {
		this.in = new DataInputStream(in);
	}

	public int read() throws IOException {
		int read = this.in.read();
		if (read == -1)
			return read;
		read = Character.toLowerCase((char) read);
		return read;
	}

}
