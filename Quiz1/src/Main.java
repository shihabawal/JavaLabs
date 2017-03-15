
public class Main {

	public static void main(String[] args) {
		MyInt firstvalue = new MyInt();
		MyInt secondvalue = new MyInt();
		MyInt mypointer = new MyInt();
		
		mypointer = firstvalue;
		mypointer.x = 10;
		mypointer = secondvalue;
		mypointer.x = 20;
		System.out.println("First value = " + firstvalue.x);
		System.out.println("Second value = " + secondvalue.x);

	}

}
