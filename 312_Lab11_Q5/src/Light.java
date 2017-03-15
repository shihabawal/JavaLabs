import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Light extends JPanel {
	String name;
	JRadioButton r;

	public Light(String n) {
		name = n;
		r = new JRadioButton(name);
		r.setSelected(false);
	}

	public void on() {
		r.setSelected(true);
	}

	public void off() {
		r.setSelected(false);
	}

	public void add() {
		this.add(r);
	}

}