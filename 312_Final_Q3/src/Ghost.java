import java.util.ArrayList;
import java.util.Random;

public class Ghost implements Observer, Runnable {
	private ArrayList<Observer> observers;
	PacMan pacman;
	boolean pacdead;
	int px, py;
	int x, y;

	public Ghost(PacMan pacman) {
		super();
		observers = new ArrayList<Observer>();
		this.x = 0;
		this.y = 0;
		this.pacman = new PacMan(0, 0);
		this.pacman = pacman;
		pacdead = false;
	}

	@Override
	public void update(int x, int y, boolean pacdead) {
		// TODO Auto-generated method stub
		this.px = x;
		this.py = y;
		this.pacdead = pacdead;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Random r = new Random();
				x = r.nextInt(500) + 1;
				y = r.nextInt(500) + 1;
				Thread.sleep(500);
				if (pacdead) {
					System.out.println("Ghost" + this
							+ " cannot eat pacman because it is already dead!");
				} else if (x < px + 50 && y < py + 50 && x > px - 50
						&& y > py - 50) { // if in range eat pacman
					pacman.setNotdead(false);
					System.out.println("Ghost" + this + " eat pacman!");
				} else {

					System.out.println("Ghost" + this
							+ " is too far to eat pacman");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
