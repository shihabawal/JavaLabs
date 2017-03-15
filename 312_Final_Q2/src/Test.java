public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ghost g1 = new Ghost();
		Thread t1 = new Thread(g1);
		t1.start();
	}

}
