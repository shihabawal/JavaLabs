import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Test {

	public static void main(String[] args) {
		try {			
			RandomGen rgen = new RandomGen();
			RandomEvenSum reven = new RandomEvenSum(rgen.getPosEven());
			RandomOddSum rodd = new RandomOddSum(rgen.getPosOdd());
			
			Thread t1 = new Thread(rgen);
			Thread t2 = new Thread(reven);
			Thread t3 = new Thread(rodd);
			
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
