public class Player implements Runnable {

	Thread t;
	Ball b;

	public Player(String name, Ball b) {
		t = new Thread(this);
		t.start();
		t.setName(name);
		this.b = b;
	}

	synchronized public void engaged(boolean ball) {
		if (ball)
			System.out.println(this + "from team " + t.getName()
					+ " just engaged with the Ball");
		try {
			t.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.release();
	}

	public void run() {
		while (true) {
			boolean ball = b.get();
			engaged(ball);
		}
	}

}
