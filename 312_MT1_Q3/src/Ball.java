public class Ball {
	boolean ball;

	public boolean get() {
		ball = true;
		return true;
	}

	public boolean release() {
		ball = false;
		return false;
	}
}
