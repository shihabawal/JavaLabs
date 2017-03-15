public class NewRunnable implements Runnable {

	public void run() {
		System.out.println("Thread created by extending Thread class");
		System.out.println(Thread.currentThread().getName());
	}
}
