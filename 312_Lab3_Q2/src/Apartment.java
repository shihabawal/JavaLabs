public class Apartment extends Unit{
	
	public Apartment (int id, double area, int bedrooms, int bathooms, String status, String usage) {
		this.id = id;
		this.area = area;
		this.bedrooms = bedrooms;
		this.bathrooms = bathooms;
		this.status = status;
		this.usage = usage;
		this.type = "Apartment";
	}

	public double mcharge() {
		return 1000;
	}

	public double rent() {
		return 50000;
	}

	public String toString() {
		return "Apartment: id=" + id + ", bedrooms=" + bedrooms
				+ ", bathrooms=" + bathrooms + ", type=" + type + ", status="
				+ status + ", usage=" + usage + ", area=" + area;
	}
	
}
