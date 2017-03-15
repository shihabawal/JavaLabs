public class Omnivore extends Animal {
	private String diet;

	Omnivore(String name) {
		super(name);
		setDiet("Plants and animals");
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}
}
