public class LightOnCommand implements Command{
	
	private Light l;

	public LightOnCommand(Light l){
		this.l = l;
		this.l.off();		
	}

	@Override
	public void execute() {
		l.on();
	}

	@Override
	public void undo() {
		l.off();
	}
}
