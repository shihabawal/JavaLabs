public class Car extends Vehicle {

	public Car(double weight, double price) {
		this.wheels = 4;
		this.weight = weight;
		this.price = price;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getWheels() {
		return this.wheels;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public double weightPerWheel() {
		return this.weight / this.wheels;
	}

}
