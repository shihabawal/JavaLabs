public class Villa extends Unit{
	
	public Villa (int id, double area, int bedrooms, int bathooms, String status, String usage) {
		this.id = id;
		this.area = area;
		this.bedrooms = bedrooms;
		this.bathrooms = bathooms;
		this.status = status;
		this.usage = usage;
		this.type = "Villa";
	}

	public double mcharge() {
		return 2000;
	}

	public double rent() {
		return 100000;
	}

	public String toString() {
		return "Villa: id=" + id + ", bedrooms=" + bedrooms + ", bathrooms="
				+ bathrooms + ", type=" + type + ", status=" + status
				+ ", usage=" + usage + ", area=" + area;
	}
	
}
