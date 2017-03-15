public class Cyberman implements Runnable {
	public boolean seen;
	Thread t;

	public Cyberman() {
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		seen = true;
		try {
			Thread.sleep(100);
			seen = false;
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
