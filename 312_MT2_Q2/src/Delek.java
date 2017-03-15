import java.util.ArrayList;
import java.util.Random;


public class Delek implements Subject, Runnable{
	private ArrayList observers;
	private Random r;
	public int sensorval;
	public boolean available;
	Thread t;
	
	public Delek(){
		t = new Thread(this);
		t.start();
	}
	
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	public void removeObsever(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i>=0) observers.remove(i);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int j =0; j<observers.size(); j++)
		{
		  Observer observer = (Observer)observers.get(j); 
		  observer.update();
		}
	}

	public void run() {
		while (true) {
			available = true;
			r = new Random();
			sensorval = r.nextInt(100) + 1;
			try {
				Thread.sleep(100);
				available = false;
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
