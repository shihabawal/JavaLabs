import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class GenerateRandom implements Subject, Runnable {

	private ArrayList observers;
	private int rvalue;
	Random r;

	public GenerateRandom() {
		observers = new ArrayList();
		r = new Random();
		notifyObservers();
	}

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (this) {
					rvalue = r.nextInt(100);
					System.out.println(rvalue);
					notifyObservers();
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(GenerateRandom.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);

	}

	@Override
	public void removeObsever(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(rvalue);
		}

	}

}