public class Test {

	public static void main(String[] args) {
		Object lock = new Object();
		Count c = new Count();
		Thread1 t1 = new Thread1("First Thread", c,lock );
		Thread2 r = new Thread2(c,lock);
		Thread t2 = new Thread(r, "Second thread");
		
		t1.start();
		t2.start();
	}

}
