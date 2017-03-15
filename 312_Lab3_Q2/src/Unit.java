public abstract class Unit {
	public int id, bedrooms, bathrooms;
	public String type, status, usage;
	public double area;

	public abstract double mcharge();
	
	public abstract double rent();
}
