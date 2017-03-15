import javax.swing.JFrame;

public class LA12E1Solns {

	public static void main(String[] args) {
		// TODO code application logic here

		DisplayFrame frame = new DisplayFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		GenerateRandom gr = new GenerateRandom();
		gr.registerObserver(frame);
		Thread t2 = new Thread(gr, "Rand Gen");
		t2.start();

	}

}