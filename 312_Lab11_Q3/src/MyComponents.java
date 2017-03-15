import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MyComponents implements ActionListener {
	Frame f1, f2;

	// panels
	JPanel panel1, panel2, panel3, panel4, panel5, pblank;

	// buttons
	JButton clr, submit, disp;

	// labels
	JLabel nameL, emailL, ageL, osL, commentsL, customerinfoL;

	// texts
	JTextField nameT, emailT;
	JTextArea commentsT, customerinfoT;
	JScrollPane scrollpanel;

	// radio buttons
	JRadioButton rlt18, r26to40, r18to25, rgt40;
	ButtonGroup rbg;

	JCheckBox win, solaris, linux, hp;

	GridLayout frameLayout;

	ArrayList<Customer> customers;

	public MyComponents() {
		customers = new ArrayList<Customer>();
		int wt = 25, ht = 10;

		clr = new JButton("Clear");
		clr.addActionListener(this);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		disp = new JButton("Display All info");
		disp.addActionListener(this);

		nameL = new JLabel("Name");
		emailL = new JLabel("Email Address");
		ageL = new JLabel("Age");
		osL = new JLabel("Operating Systems");
		commentsL = new JLabel("Comments");

		nameT = new JTextField();
		nameT.setSize(wt, ht);
		emailT = new JTextField();
		emailT.setSize(wt, ht);
		commentsT = new JTextArea();
		commentsT.setSize(50, 30);

		rlt18 = new JRadioButton("Less than 18");
		r26to40 = new JRadioButton("26-40");
		r18to25 = new JRadioButton("18-25");
		rgt40 = new JRadioButton("Over 40");

		win = new JCheckBox("WindowsXP");
		solaris = new JCheckBox("Solaris");
		linux = new JCheckBox("Red Hat Linux 9.0");
		hp = new JCheckBox("HP-UX");

		rbg = new ButtonGroup();
		rbg.add(rlt18);
		rbg.add(r26to40);
		rbg.add(r18to25);
		rbg.add(rgt40);

		panel1 = new JPanel(new GridLayout(2, 2));
		panel1.add(nameL);
		panel1.add(nameT);
		panel1.add(emailL);
		panel1.add(emailT);

		panel2 = new JPanel(new GridLayout(2, 3));
		panel2.add(ageL);
		panel2.add(rlt18);
		panel2.add(r26to40);
		panel2.add(new JLabel(""));
		panel2.add(r18to25);
		panel2.add(rgt40);

		panel3 = new JPanel(new GridLayout(2, 3));
		panel3.add(osL);
		panel3.add(win);
		panel3.add(linux);
		panel3.add(new JLabel(""));
		panel3.add(solaris);
		panel3.add(hp);

		panel4 = new JPanel(new GridLayout(1, 2));
		panel4.add(commentsL);
		panel4.add(commentsT);

		panel5 = new JPanel(new GridLayout(1, 3));
		panel5.add(clr);
		panel5.add(submit);
		panel5.add(disp);

		pblank = new JPanel();

		f1 = new Frame();
		f1.setLayout(new GridLayout(6, 1));
		f1.add(panel1);
		f1.add(panel2);
		f1.add(panel3);
		f1.add(panel4);
		f1.add(new JPanel());
		f1.add(panel5);
		f1.setSize(400, 300);
		f1.setVisible(true);

		customerinfoL = new JLabel("Customer Information:");
		customerinfoT = new JTextArea();
		scrollpanel = new JScrollPane(customerinfoT);
		customerinfoT.setLineWrap(true);
		
		f2 = new Frame();
		f2.setLayout(new BorderLayout());
		f2.add(customerinfoL, BorderLayout.NORTH);
		f2.add(scrollpanel, BorderLayout.CENTER);
		f2.setSize(400, 600);
		f2.setVisible(false);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clr) {
			nameT.setText("");
			emailT.setText("");
			commentsT.setText("");
			rbg.clearSelection();
			win.setSelected(false);
			linux.setSelected(false);
			solaris.setSelected(false);
			hp.setSelected(false);
		} else if (ae.getSource() == submit) {
			String name = "", email = "", age = "", os = "", comments = "";
			name = nameT.getText();
			email = emailT.getText();
			comments = commentsT.getText();
			if (r18to25.isSelected())
				age = "18-25";
			else if (r26to40.isSelected())
				age = "26-40";
			else if (rlt18.isSelected())
				age = "Less than 18";
			else
				age = "Over 40";

			if (win.isSelected())
				os += "WindowsXP";
			if (linux.isSelected())
				os += ", " + "Red Hat Linux 9.0";
			if (solaris.isSelected())
				os += ", " + "Solaris";
			if (hp.isSelected())
				os += ", " + "HP-UX";

			customers.add(new Customer(name, email, age, os, comments));
		} else if (ae.getSource() == disp) {
			String data = "------------\n";
			for (int i = 0; i < customers.size(); i++) {
				data += customers.get(i).toString();
				data += "\n------------\n------------\n------------\n";
			}
			customerinfoT.setText(data);
			f1.setVisible(false);
			f2.setVisible(true);
		}
	}
}