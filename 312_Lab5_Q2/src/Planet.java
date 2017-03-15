public class Planet {

	private String name;
	private double orbit, diameter, mass;
	
	public Planet(){
		name = "";
		orbit = 0;
		diameter = 0;
		mass = 0;
	}

	public Planet(String name, double orbit, double diameter, double mass) {
		super();
		this.name = name;
		this.orbit = orbit;
		this.diameter = diameter;
		this.mass = mass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOrbit() {
		return orbit;
	}

	public void setOrbit(double orbit) {
		this.orbit = orbit;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
}
