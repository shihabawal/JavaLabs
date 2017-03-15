import java.util.ArrayList;

public class FanRoller implements Subject {
	private ArrayList observers;
	private String sname;
	private int svalue;
	ArrayList<Player> players;

	public FanRoller() {
		players = new ArrayList<Player>();
		observers = new ArrayList();
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(sname, svalue);
		}
	}

	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	public void removeObsever(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	void sValueChanged() {

		notifyObservers();
	}

	public void setNewValues(String sname, int svalue) {
		this.sname = sname;
		this.svalue = svalue;

		players.add(new Player(svalue, this.sname));

		sValueChanged();
	}

	public ArrayList<Player> getPlayers() {

		return players;

	}

}
