import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run(){
				for (int i=0; i<10; i++){
					Random r = new Random();
					System.out.println("Random no = " + (r.nextInt(100) + 1));
				}
				System.out.println("Thread that generates random nos is stopping");
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread stopping");
	}
}
