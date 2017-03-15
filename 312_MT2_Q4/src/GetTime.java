import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class GetTime {
	DataInputStream in;
	DataOutputStream out;
	BigInteger num;

	public GetTime(InputStream in, OutputStream out, BigInteger num) {
		this.in = new DataInputStream(in);
		this.out = new DataOutputStream(out);
		this.num = num;
	}

	void read() throws IOException{
		byte[] data = null;
		in.read(data);
		num = new BigInteger(data);
		BigInteger temp = num;
		System.out.println("x=" + num.intValue());
		temp.shiftRight(128);
		System.out.println("y=" + num.intValue());
		temp.shiftRight(128);
		System.out.println("z=" + num.intValue());
		temp.shiftRight(128);
		System.out.println("time=" + num.intValue());
		System.out.print(num);
	}
}
