public class ComplexControlPanel {

	private Command oncommands[], offcommands[];

	public ComplexControlPanel() {
		
		oncommands = new Command[5];
		offcommands = new Command[5];
		
		Command nocommand = new NoCommand();
		
		for (int i = 0; i < 5; i++) {
			oncommands[i] = nocommand;
			offcommands[i] = nocommand;
		}
	}

	public void setCommand(int i, Command oncommand, Command offcommand) {
		oncommands[i] = oncommand;
		offcommands[i] = offcommand;
	}

	public void onButtonWasPushed(int i) {
		oncommands[i].execute();
	}

	public void offButtonWasPushed(int i) {
		offcommands[i].execute();
	}
	
	public void undoAllOn(int i) {
		oncommands[i].undo();
	}

}
