import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

class GameFrame extends JFrame implements ActionListener,
Observer, Runnable {

	private String playerName;
	private FanRoller ourRoller;
	private int score = 0;
	
	driver ourDriver;
	Random rand = new Random();
	int counter = 5;
	int ONTIME =  rand.nextInt(4) + 3;
    JLabel l1;
    JLabel l2;
    int myrand;
	GameFrame (int myr,FanRoller Roller, String name) {
		
		this.playerName = new String();
		this.ourRoller = Roller;
		ourRoller.registerObserver(this);
		this.playerName = name;
		myrand = myr;
	 l1 = new JLabel ("Fan Starts in..." + counter);
	l1.setFont(new Font(null, 0, 30));
	 l2 = new JLabel ("ON TIME = " +myrand);
	l2.setFont(new Font(null, 0, 30));

	setLayout(new GridLayout(2, 1));
	setSize(400, 300);
	add(l1);
	add(l2);
	this.setVisible(true);
	Thread t = new Thread(this,"ROLL");
	t.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if (counter >0) {
				l1.setText("Fan Starts in... " +counter);

				counter--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (counter == 0){
					
					l1.setText("SWOOOOOOT!!");
					ourDriver = new driver("/dev/cu.usbserial-A901JYVO");
					ourDriver.openPort();
					
					if (ourDriver.isStopped()){
					int dist = ourDriver.getRange();
					
					ourRoller.setNewValues(playerName, dist);
					l1.setText("Your Score is " + score );
					this.remove(l2);
					ourDriver.closePort();

					}
					
				}
				}
		}
		
	}

	@Override
	public void update(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}