
public class Kitten implements Runnable{
	private boolean batt;
	private Thread t;
	
	public Kitten(){
		t = new Thread(this);
		t.start();
	}
	
	public void changeBatt(){
		batt = !batt;
	}
	
	public boolean available(){
		return batt;
	}
	
	public void run() {
		while (true){
			changeBatt();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
