import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyThread implements Runnable{
	
	private DataInputStream in;
	private DataOutputStream out;
	
	public CopyThread(InputStream fis, OutputStream fos, String name) {
		in = new DataInputStream(fis);
		out = new DataOutputStream(fos);
	}

	public void run() {
		int read;
		try {
			read = in.read();
			while (read != -1){
				out.write(read);
				read = in.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Copy thread finished copying");
	}
}
