public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ghost g1 = new Ghost(424, 241);
		Thread t1 = new Thread(g1);
		t1.start();
		Ghost g2 = new Ghost(365, 325);
		Thread t2 = new Thread(g2);
		t2.start();
		Display d1 = new Display(g1);
		Display d2 = new Display(g1);
		Display d3 = new Display(g2);
		Display d4 = new Display(g2);
		g1.registerObserver(d1);
		g1.registerObserver(d2);
		g2.registerObserver(d3);
		g2.registerObserver(d4);
	}

}
