public class Test {

	public static void main(String[] args) {
		WindowsComputer c1 = new WindowsComputer();
		UnixComputer c2 = new UnixComputer();
		c1.assemble();
		c1.installOS();
		c1.supply("Ahmed");
		
		System.out.println("");
		c2.assemble();
		c2.installOS();
		c2.supply("Mohammad");
	}

}
