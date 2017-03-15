public class BasicTriangle implements ITriangle {
	private double base, height;
	
	public BasicTriangle(double base, double height){
		this.base = base;
		this.height = height;
	}

	public double getArea() {
		return .5 * base * height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
