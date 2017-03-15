import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyComponents implements ActionListener {
	Frame f;
	JButton b1;
	JButton b2;
	JButton b3;
	JTextField t;
	Container c;
	GridLayout layout;

	public MyComponents()
	{		
	    layout = new GridLayout(3,1);
	    f = new Frame("Java Frame"); 
	    f.setLayout(layout);
	    b1 = new JButton("Java");
	    f.add(b1); 
	    b1.addActionListener(this);
	    	    
	    b3 = new JButton("Exit");
	    f.add(b3); 
	    b3.addActionListener(this);
		   	    
	    t = new JTextField("Text Field");
	    t.setSize(25, 10);
	    f.add(t); 
	    f.setSize(400,300)  ;
	    f.setVisible(true); 	    
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b3) {
			System.exit(0);
		} else if (ae.getSource() == b1) {
			t.setText("Java");
			t.setVisible(true);
		}
	}
}