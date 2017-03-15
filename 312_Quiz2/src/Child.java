public class Child implements Runnable {

	private Thread t;
	private boolean batt;
	Kitten k;

	public Child(Kitten k) {
		t = new Thread(this);
		t.start();
		this.k = k;
		batt = k.available();
	}

	public void run() {
		synchronized (k) {
			while (true) {
				if (batt) {
					System.out.println(this + " playing with " + k);
					batt = k.available();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
