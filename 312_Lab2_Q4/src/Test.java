public class Test {
	public static void main(String[] args) {
		Car car1 = new Car(954.6, 135200.0);
		Truck truck1 = new Truck(10, 3520.0, 950000.0);
		System.out.println("Car 1 specifications:");
		System.out.println("Wheels: " + car1.getWheels());
		System.out.println("Weight: " + car1.getWeight());
		System.out.println("Price: " + car1.getPrice());
		System.out.println("Weight per wheel: " + car1.weightPerWheel());
		
		System.out.println("");
		System.out.println("Truck 1 specifications:");
		System.out.println("Wheels: " + truck1.getWheels());
		System.out.println("Weight: " + truck1.getWeight());
		System.out.println("Price: " + truck1.getPrice());
		System.out.println("Weight per wheel: " + truck1.weightPerWheel());
	}
}
