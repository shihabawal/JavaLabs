import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class RandomNumberSum implements Runnable {
	private PipedInputStream pis;

	public RandomNumberSum(PipedOutputStream pos) throws IOException {
		this.pis = new PipedInputStream(pos);
	}

	public void run() {
		try {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += pis.read();
			}// for
			System.out
					.println("Thread 2 printing sum of all the random numbers = "
							+ sum);
		} catch (IOException e) {
			e.printStackTrace();
		}// try-catch
	}// run

}
