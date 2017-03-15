
public class Test {

	public static void main(String[] args) {
		SonicSD s = new SonicSD();
		s.setSDBehavior(new LockPicker());
		s.actionRecipe();
		s.setSDBehavior(new BurnerCutter());
		s.actionRecipe();
	}

}
