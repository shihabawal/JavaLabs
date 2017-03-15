public class Lab6E4 {
	public static void main(String args[]) {
		Callme target = new Callme();
		Caller one = new Caller(target, "One");
		Caller two = new Caller(target, "Two");
		Caller three = new Caller(target, "Three");
	}
}