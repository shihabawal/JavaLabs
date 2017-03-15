public class Homosepien extends Omnivore {
	private String characterstics;

	Homosepien(String name) {
		super(name);
		setCharacterstics("Thinks wisely");
	}

	public String getCharacterstics() {
		return characterstics;
	}

	public void setCharacterstics(String characterstics) {
		this.characterstics = characterstics;
	}

}
