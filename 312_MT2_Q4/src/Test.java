import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		BigInteger num = new BigInteger("0256468458645654");
		num = in.nextBigInteger();
		System.out.println(num);
		GetTime t = new GetTime(System.in, System.out, num);
		try {
			t.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
