public class Person {
	public Trial[] trials;
	public Person(){
		trials = new Trial[15];
		for (int i=0; i<15; i++){
			trials[i] = new Trial();
		}
	}
}
