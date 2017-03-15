public class Thread2 implements Runnable {
	Count c;
	Object o;

	public Thread2(Count c, Object o) {
		this.c = c;
		this.o = o;
	}

	public void run() {
		while (c.getCount() <= 6) {
			synchronized (o) {

				System.out.println(Thread.currentThread().getName()
						+ c.getCount());
				c.increment();
			}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			

		}

	}
}