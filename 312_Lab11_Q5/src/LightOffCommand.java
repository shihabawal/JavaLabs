public class LightOffCommand implements Command{
	
	private Light l;
	
	public LightOffCommand(Light l) {
		this.l = l;
		this.l.off();
	}

	@Override
	public void execute() {
		l.off();
	}
	
	@Override
	public void undo() {
		l.on();
	}
}
