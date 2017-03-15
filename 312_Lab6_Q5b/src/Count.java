public class Count {
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Count(){
		count = 0;
	}
	
	synchronized public int increment(){
		return count++;
	}
}
