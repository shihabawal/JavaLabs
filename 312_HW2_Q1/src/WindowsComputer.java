public class WindowsComputer implements IComputer {

	public void assemble() {
		System.out.println("Computer Assembled");
	}

	public void installOS() {
		System.out.println("Inslalled Windows operating System");
	}

	public void supply(String client) {
		System.out.println("Computer with Windows OS supplied to " + client);
	}

}
