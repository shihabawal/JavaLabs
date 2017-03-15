public class Test {

	public static void main(String[] args) {
		PhoneBoth p = new PhoneBoth();
		Caller c1 = new Caller(p, "Tom");
		Caller c2 = new Caller(p, "Alex");
		Caller c3 = new Caller(p, "Jerry");
		//Caller c4 = new Caller(p, "Jason");
		//Caller c5 = new Caller(p, "Peter");
	}
}
