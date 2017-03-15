import java.io.*;

public class FrenchDataInputStream extends DataInputStream implements
		FrenchRead {

	public FrenchDataInputStream(InputStream in) {
		super(in);
	}

	public int lire() throws IOException {
		return super.read();
	}

	public void fin() throws IOException {
		super.close();
	}

}
