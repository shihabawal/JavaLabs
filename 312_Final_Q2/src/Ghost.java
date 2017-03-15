import java.util.Random;

public class Ghost implements Runnable {
	int x, y;
	SpeedBehavior sb;

	public Ghost() {
		super();
		x = 0;
		y = 0;
		sb = new SlowSpeed();
	}

	public void setSpeed(SpeedBehavior sb) {
		this.sb = sb;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Random r = new Random();
			x = r.nextInt(500) + 1;
			y = r.nextInt(500) + 1;
			System.out.println("Ghost " + this + " at speed (" + x + "," + y
					+ ")");
			if (r.nextBoolean()) {
				setSpeed(new FastSpeed());
				sb.changeSpeed();
			} else if (r.nextBoolean()) {
				setSpeed(new MediumSpeed());
				sb.changeSpeed();
			} else {
				setSpeed(new FastSpeed());
				sb.changeSpeed();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
