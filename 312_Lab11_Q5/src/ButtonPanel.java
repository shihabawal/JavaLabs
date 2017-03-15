import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel implements ActionListener {
	ComplexControlPanel cp;
	JPanel p;
	JLabel l;
	JButton b[];
	String bn[] = { "Living room", "kitchen", "Dummy", "Stereo", "Dummy" };
	JFrame f;

	public ButtonPanel(ComplexControlPanel cp) {
		this.cp = cp;

		p = new JPanel(new GridLayout(5, 2));
		b = new JButton[5];
		f = new JFrame("Button Panel");

		for (int i = 0; i < 4; i++) {
			b[i] = new JButton("ON");
			l = new JLabel(bn[i]);
			b[i].addActionListener(this);
			p.add(l);
			p.add(b[i]);
		}
		
		b[4] = new JButton("UndoAllOn");
		l = new JLabel(bn[4]);
		b[4].addActionListener(this);
		p.add(l);
		p.add(b[4]);
		
		f.add(p);
		f.setSize(400, 150);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 4; i++) {
			if (e.getSource() == b[i]) {
				if (b[i].getText().compareToIgnoreCase("ON") == 0) {
					b[i].setText("OFF");
					cp.offButtonWasPushed(i);
				} else {
					b[i].setText("ON");
					cp.onButtonWasPushed(i);
				}

			}
		}
		if (e.getSource() == b[4]) {
			for (int i = 0; i < 4; i++) {
				cp.undoAllOn(i);
				b[i].setText("OFF");
			}
		}
	}
}
