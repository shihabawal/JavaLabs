import java.util.ArrayList;
import java.util.Random;

public class Ghost implements Subject, Runnable {
	private ArrayList<Observer> observers;
	int x, y;

	public Ghost(int x, int y) {
		super();
		observers = new ArrayList<Observer>();
		this.x = x;
		this.y = y;
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
			observer.update(x, y);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Random r = new Random();
			x = r.nextInt(500) + 1;
			y = r.nextInt(500) + 1;
			notifyObservers();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
