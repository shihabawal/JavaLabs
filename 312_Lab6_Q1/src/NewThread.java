public class NewThread extends Thread {
	public NewThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println("Thread created by extending Thread class");
		System.out.println(Thread.currentThread().getName());
	}
}
