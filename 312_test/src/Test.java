public class Test {

	public static void main(String[] args) {
		Bird [] birds = new Bird[100];
		for(int i = 0; i<birds.length; i++){
			birds[i]=new Bird(System.out);
		}
	}
}