public class Student extends GUILogin {
	private String name, major;
	private int ID;

	Student(int ID, String name, String major){
		this.ID = ID;
		this.name = name;
		this.major = major;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String toString() {
		return "name=" + name + ", major=" + major
				+ ", ID=" + ID;
	}
}
