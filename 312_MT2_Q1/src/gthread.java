
public class gthread implements Runnable {
	Cyberman c;
	Thread t;
	int seennum;
	
	public gthread(Cyberman c){
		this.c = c;
		t = new Thread(this);
		t.start();
		seennum = 0;
	}
	
	void seen(){
		if (c.seen){
			
		}
	}
		
	public void run() {
		seen();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
