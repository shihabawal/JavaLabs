public class Thread1 extends Thread {
	Count c;
	Object o;

	public Thread1(String name, Count c, Object o) {
		super(name);
		this.c = c;
		this.o = o;

	}

	public void run() {
		while (c.getCount() <= 6) {

			System.out
					.println(Thread.currentThread().getName() + c.increment());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
