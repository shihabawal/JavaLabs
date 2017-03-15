public class UnixComputer implements IComputer{

	public void assemble() {
		System.out.println("Computer Assembled");
	}

	public void installOS() {
		System.out.println("Inslalled Unix operating System");
	}

	public void supply(String client) {
		System.out.println("Computer with Windows OS supplied to " + client);
	}
}
