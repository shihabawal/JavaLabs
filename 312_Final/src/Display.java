public class Display implements Observer {

	Subject ghost;
	int x, y;

	public Display(Subject ghost) {
		x = 0;
		y = 0;
		this.ghost = new Ghost(0, 0);
		this.ghost = ghost;
	}

	@Override
	public void update(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		System.out.println("Display " + this + " shows " + ghost
				+ " at position (" + x + "," + y + ")");
	}
}
