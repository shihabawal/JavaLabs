public class Test {

	public static void main(String[] args) {
		Omnivore bear = new Omnivore("Bear1");
		Homosepien person1 = new Homosepien("Shihab");
		Animal animal1 = new Animal("Rabit");
		System.out.println("Animal:");
		System.out.println("Name: " + animal1.getName());
		System.out.println("");
		
		System.out.println("Omnivore:");
		System.out.println("Name: " + bear.getName());
		System.out.println("Diet: " + bear.getDiet());
		System.out.println("");
		
		System.out.println("Homosepien:");
		System.out.println("Name: " + person1.getName());
		System.out.println("Diet: " + person1.getDiet());
		System.out.println("Diet: " + person1.getCharacterstics());
		System.out.println("");

		System.out.println("Changed characterstics for Homosepien: ");
		person1.setCharacterstics("Computer Engineer in AUS");
		System.out.println("Name: " + person1.getName());
		System.out.println("Diet: " + person1.getDiet());
		System.out.println("Diet: " + person1.getCharacterstics());
	}

}
