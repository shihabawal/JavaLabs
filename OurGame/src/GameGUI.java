
public class GameGUI implements Observer{
	private String playerName;
	private int score;
	private Subject ourRoller;
    public GameGUI(Subject Roller)
	{
	this.ourRoller = Roller;
	ourRoller.registerObserver(this);
	}
	public void update(String playerName, int score) {
	// TODO Auto-generated method stub
	this.playerName = playerName;
	this.score = score;
	display();
	}
	public void display () 
	{
	
	
	}

}
