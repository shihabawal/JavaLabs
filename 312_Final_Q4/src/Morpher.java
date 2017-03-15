import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class Morpher {
	DataInputStream din;
	DataOutputStream dos;

	public Morpher(InputStream is, OutputStream os) {
		din = new DataInputStream(is);
		dos = new DataOutputStream(os);
	}

	public void morph() {
		while (true) {
			try {
				char c = din.readChar();
				Random r = new Random();
				int num = r.nextInt(3);
				switch (num){
				case 0:
					dos.writeLong((long)c);
					break;
				case 1:
					dos.writeInt((int)c);
					break;
				case 2:
					dos.writeFloat((float)c);
					break;
				case 3:
					dos.writeDouble((double)c);
					break;
				}
			} catch (EOFException e) {
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
