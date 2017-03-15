import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;

public class RandomNumberGen implements Runnable {
	private PipedOutputStream pos;

	public RandomNumberGen() {
		this.pos = new PipedOutputStream();
	}

	public PipedOutputStream getPos() {
		return pos;
	}

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
			}// try-catch
		}// for
	}// run

}
