import java.util.ArrayList;
import java.util.Random;

public class PacMan implements Subject, Runnable {

	private ArrayList<Observer> observers;
	boolean notdead;
	int x, y;

	public PacMan(int x, int y) {
		super();
		this.observers = new ArrayList<Observer>();
		this.x = x;
		this.y = y;
		notdead = true;
	}

	public boolean isNotdead() {
		return notdead;
	}

	public void setNotdead(boolean notdead) {
		this.notdead = notdead;
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObsever(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(x, y, !notdead);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Random r = new Random();
				this.x = r.nextInt(500) + 1;
				this.y = r.nextInt(500) + 1;
				if (notdead) {
					System.out.println("Pacman is at position(" + x + "," + y
							+ ")");
				}
				notifyObservers();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
