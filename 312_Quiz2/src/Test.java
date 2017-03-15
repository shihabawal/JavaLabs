public class Test {

	public static void main(String[] args) {
		Kitten k1 = new Kitten();
		Kitten k2 = new Kitten();
		Kitten k3 = new Kitten();
		Child c1 = new Child(k1);
		Child c2 = new Child(k2);
		Child c3 = new Child(k3);
	}

}
