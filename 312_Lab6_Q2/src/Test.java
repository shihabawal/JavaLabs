public class Test {

	public static void main(String[] args) {
		NewRunnable runnable = new NewRunnable();
		Thread	t = new Thread(runnable, "RunnableThread");
		t.start();
	}
}
