public class NormalStudent extends Student {

	public NormalStudent(int id, int absence) {
		super(id, absence, "normal");
	}

	public boolean exceedsAbsences() {
		return (this.getAbsence() >= 4);
	}

	public String toString() {
		return getId() + "\t" + getAbsence();
	}

}
