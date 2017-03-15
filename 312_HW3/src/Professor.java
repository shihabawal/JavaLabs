public class Professor extends CUILogin {
	private String name, department;
	private int ID;

	Professor(int ID, String name, String department){
		this.ID = ID;
		this.name = name;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String toString() {
		return "name=" + name + ", department=" + department
				+ ", ID=" + ID;
	}
}
