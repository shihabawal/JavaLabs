public class Caller implements Runnable {

	private String name;
	private PhoneBoth p;
	private Thread t;

	public Caller(PhoneBoth p, String name) {
		this.p = p;
		this.name = name;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				p.makeCall(name);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (MyException e) {
				System.out.println("PhoneBooth is busy");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}// try-catch
		}// while (true)
	}// run()

}
