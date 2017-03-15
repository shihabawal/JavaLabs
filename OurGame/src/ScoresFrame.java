import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ScoresFrame extends JFrame implements ActionListener, Runnable {
	
	
    JButton exitB ;
    FanRoller f;
    JTextArea t;
	
	ScoresFrame (FanRoller f){
		
		
		
		this.f = new FanRoller ();
		this.f = f;
		
	    JLabel l1 = new JLabel("Scores");

	    exitB = new JButton("EXIT");
	    JScrollPane jp;
		t = new JTextArea();


		setLayout(new GridLayout(3, 1));
		setSize(300, 500);
		jp = new JScrollPane();
		jp.getViewport().add(t);
		add(l1);
		add(jp);
		add(exitB);
		this.setVisible(true);
		Thread th = new Thread(this,"ROLL");
		th.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true){
			
			for (int i=0; i < f.getPlayers().size(); i++){
				
				t.setText(i + ")  " + f.getPlayers().get(i).getName() +" Score: " + f.getPlayers().get(i).getScore()+ "\n");
			}
			
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitB ){
			
			
		}
	}
}
