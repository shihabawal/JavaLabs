public class Test {

	public static void main(String[] args) {
		PacMan p = new PacMan(0, 0);
		Thread t = new Thread(p);
		t.start();
		Ghost g1 = new Ghost(p);
		Thread t1 = new Thread(g1);
		t1.start();
		Ghost g2 = new Ghost(p);
		Thread t2 = new Thread(g2);
		t2.start();
		Ghost g3 = new Ghost(p);
		Thread t3 = new Thread(g3);
		t3.start();
		Ghost g4 = new Ghost(p);
		Thread t4 = new Thread(g4);
		t4.start();
		p.registerObserver(g1);
		p.registerObserver(g2);
		p.registerObserver(g3);
		p.registerObserver(g4);
	}

}
