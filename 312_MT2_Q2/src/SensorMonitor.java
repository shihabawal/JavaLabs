public class SensorMonitor implements Observer, Runnable {
	Delek[] d;
	Thread t;

	public SensorMonitor(Delek[] d) {
		this.d = d;
		t = new Thread(this);
		t.start();
	}

	public void update() {
		for (int i = 0; i < d.length; i++) {
			System.out.println("SensorMonitor" + this + " Received:{");
			if ((boolean) d[i].available) {
				System.out.print(d[i].sensorval + " ");
			}
			System.out.println("}");
		}
	}

	@Override
	public void run() {
		synchronized (d) {
			while (true) {
				update();
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
