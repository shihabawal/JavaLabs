public class Test {

	public static void main(String[] args) {
		ITriangle t;
		t = new BasicTriangle(2.0, 4.0);
		
		System.out.println("Basic Trianlge: height = " + ((BasicTriangle) t).getHeight() + " base = " + ((BasicTriangle) t).getBase());
		System.out.println("Basic Trianlge: Area = " + t.getArea());
		
		t  = new HeronTriangle(3, 3, 3);
		System.out.println("Heron Trianlge: a = " + ((HeronTriangle) t).getSideA() + " b = " + ((HeronTriangle) t).getSideB() + " c = " + ((HeronTriangle) t).getSideC());
		System.out.println("Heron Trianlge: Area = " + t.getArea());
	}

}
