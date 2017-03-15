
public class Number implements TriOps {
	Number(){}
	
	Number(double num){
		x = num;
	}
	
	private double x;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	public double sqrt(){
		return Math.sqrt(x);
	}
	public double square(){
		return x*x;
	}
	public double sine(){
		double temp = (x*Math.PI)/180;
		return Math.sin(temp);
	}
	public double cosine(){
		double temp = (x*Math.PI)/180;
		return Math.cos(temp);
	}
	public double tan(){
		double temp = (x*Math.PI)/180;
		return Math.tan(temp);
	}
}
