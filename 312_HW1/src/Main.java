
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int fact, n=5;
		fact = factorial(n);
		System.out.println("Factorial of " + n + " is " + fact);
	}
	
	public static int factorial(int n){
		int fact = 1;
		for (int i=1; i<=n; i++){
			fact *= i;
		}
		return fact;
	}

}
