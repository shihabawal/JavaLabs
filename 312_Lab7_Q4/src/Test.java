import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		try {
			final PipedOutputStream pos = new PipedOutputStream();
			final PipedInputStream pis = new PipedInputStream(pos);
			Thread randomNumberGen = new Thread(new Runnable() {

				public void run() {
					System.out.println("Thread 1 generating random numbers");
					for (int i = 0; i < 10; i++) {
						try {
							Random r = new Random();
							int num = r.nextInt(100) + 1;
							pos.write(num);
							System.out.println("Random value = " + num);
						} catch (IOException e) {
							e.printStackTrace();
						}//try-catch
					}//for
				}//run
			});
			Thread randomNumberSum = new Thread(new Runnable() {

				public void run() {
					try {
						int sum = 0;
						for (int i = 0; i < 10; i++) {
							sum += pis.read();
						}//for
						System.out
								.println("Thread 2 printing sum of all the random numbers = "
										+ sum);
					} catch (IOException e) {
						e.printStackTrace();
					}//try-catch
				}//run
			});
			randomNumberGen.start();
			randomNumberGen.join();
			randomNumberSum.start();
			randomNumberSum.join();
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
