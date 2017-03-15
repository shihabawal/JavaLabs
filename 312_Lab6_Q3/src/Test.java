import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		System.out.println("Enter first integer: ");
		a = in.nextInt();
		System.out.println("Enter second integer: ");
		b = in.nextInt();

		NewThread t1 = new NewThread(a, b);
		NewRunnable r = new NewRunnable(a, b);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}
