public abstract class Vehicle {
	public int wheels;
	public double weight, price;
	
	public abstract void setWheels(int wheels);
	public abstract int getWheels();
	public abstract void setWeight(double weight);
	public abstract double getWeight();
	public abstract void setPrice(double price);
	public abstract double getPrice();
	public abstract double weightPerWheel();
	
}
