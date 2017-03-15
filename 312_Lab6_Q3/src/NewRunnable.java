public class NewRunnable implements Runnable {
	private int a,b;
	
	public NewRunnable (int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		int res = a - b;
		System.out.println("Sub thread " + a + " - " + b + " = " + res);
	}
}
