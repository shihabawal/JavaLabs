public class Test {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Cyberman c1 = new Cyberman();
		Cyberman c2 = new Cyberman();
		gthread v1 = new gthread(c1);
		gthread v2 = new gthread(c1);
		gthread v3 = new gthread(c2);

	}
}
