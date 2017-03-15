import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class Snooper {

	DataInputStream is;
	PushbackInputStream ps;

	public Snooper(InputStream is) {
		this.is = new DataInputStream(is);
		this.ps = new PushbackInputStream(is);
	}

	public char readchar() throws IOException {
		char a;
		a = (char) is.read();
		if (a != 'a') {
			ps.unread(a);
			
		}
		return a;
	}
}
