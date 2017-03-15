import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class RandomOddSum implements Runnable {

	private PipedInputStream pis;

	public RandomOddSum(PipedOutputStream pos) throws IOException {
		this.pis = new PipedInputStream(pos);
	}

	public void run() {
		int num, sum = 0;
		try {
			for (int i = 0; i < 10; i++) {
				num = pis.read();
				if (num % 2 == 1) {
					sum += num;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out
				.println("The sum all the odd random numbers calculated by Third Thread = "
						+ sum);
	}
}
