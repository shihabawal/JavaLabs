public class ProbationaryStudent extends Student {

	public ProbationaryStudent(int id, int absence) {
		super(id, absence, "probation");
	}

	public boolean exceedsAbsences() {
		return (this.getAbsence() >= 2);
	}

	public String toString() {
		return getId() + "\t" + getAbsence();
	}

}
