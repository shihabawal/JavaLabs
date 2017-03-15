abstract class Computer {

	public void assemble() {
		System.out.println("Computer Assembled");
	}

	abstract void installOS();

	public void supply(String client) {
		System.out.println("Computer with OS supplied to " + client);
	}
}