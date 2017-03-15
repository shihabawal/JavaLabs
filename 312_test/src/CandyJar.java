public class CandyJar {
	private int candies;
	
	public CandyJar (int candies){
		this.candies = candies;
	}
	
	synchronized public boolean grab(){
		if (candies != 0)
			candies--;
		return candies!=0;
	}
}
