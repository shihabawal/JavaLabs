
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class myComponents implements ActionListener {

	FanRoller ourRoller = new FanRoller();

	
	int i = 0;
	Frame f;
	Frame f2;
	GameFrame f3;
	ScoresFrame SF;
	driver ourDriver;
	Container c;
	GridLayout layout;
	JButton a1;
	JButton a2;
	JButton a3;

	JButton exitB;
	JScrollPane jp;
	JTextArea t;
	JTextField name;
	Random rand = new Random();

	int myRand = rand.nextInt(5) + 3;
	int score = 0;

	public void setDriver() {

		ourDriver = new driver("/dev/cu.usbserial-A901JYVO");

		ourDriver.openPort();

	}

	public myComponents() {

		int counter = 5;
		f = new Frame("FAN-ROLLER");
		f2 = new Frame("Scores");
		GameFrame f3;

		t = new JTextArea();

		layout = new GridLayout(1, 1);
		f.setLayout(layout);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JLabel l1 = new JLabel("Fan Starts in..." + counter);
		l1.setFont(new Font(null, 0, 30));
		JLabel l2 = new JLabel("ON TIME = " + myRand);
		l2.setFont(new Font(null, 0, 30));

		name = new JTextField("enter name");
		a1 = new JButton("START");
		a1.addActionListener(this);
		a2 = new JButton("SCORES");
		a2.addActionListener(this);
		a3 = new JButton("EXIT");
		a3.addActionListener(this);
		exitB = new JButton("EXIT");
		exitB.addActionListener(this);

		p1.setLayout(new GridLayout(4, 1));
		p2.setLayout(new GridLayout(3, 1));

		p1.add(name);
		p1.add(a1);
		p1.add(a2);
		p1.add(a3);


		// first frame
		f.add(p1);
		f.setSize(200, 200);
		f.setVisible(true);
		// Scores frame

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == a1 && name.getText() != "enter name" ) {
			
			
			if (f2.isVisible() == false) {
				ourDriver = new driver("/dev/cu.usbserial-A901JYVO");
				ourDriver.openPort();
				ourDriver.setOnTime(myRand);
				ourDriver.closePort();
				f3 = new GameFrame(myRand, ourRoller,name.getText());

			}
		} else if (ae.getSource() == a2) {

			SF = new ScoresFrame(ourRoller);

		} else if (ae.getSource() == a3) {

			System.exit(0);

		} else if (ae.getSource() == exitB) {

			f2.setVisible(false);

		}
	}

}
