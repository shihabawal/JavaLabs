public class NewThread extends Thread {
	private int a,b;
	public NewThread(String name) {
		super(name);
	}
	public NewThread(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void run() {
		int res = a + b;
		System.out.println("Add thread " + a + " + " + b + " = " + res);
	}
}
