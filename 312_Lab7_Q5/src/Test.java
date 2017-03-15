import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try {
			RandomNumberGen rnumGen = new RandomNumberGen();
			RandomNumberSum rnumSum = new RandomNumberSum(rnumGen.getPos());
			Thread t1 = new Thread(rnumGen);
			Thread t2 = new Thread(rnumSum);
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			System.out.println("Main thread stopped");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
