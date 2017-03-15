
public class Test {

	public static void main(String[] args) {
		Villa v1 = new Villa(1,52000,3,3,"Available","Residency");
		Apartment a1 = new Apartment(3, 57000, 2, 3, "Occupied", "Comercial");
		
		System.out.println(v1);
		System.out.println("Rent including garden and backyard charge = " + v1.rent() + " $ Maintainence = " + v1.mcharge() + " $");
		
		System.out.println("");
		System.out.println(a1);
		System.out.println("Rent including AC charge = " + a1.rent() + " $ Maintainence = " + a1.mcharge() + " $");
	}

}
