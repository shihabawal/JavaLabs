import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Main extends JFrame {
	public int x, y, c;
	public Point p;
	ArrayList<Point> points;

	public Main() {
		// this.setLayout(new BorderLayout());
		// this.setSize(400, 400);
		this.setPreferredSize(new Dimension(400, 400));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p = new Point(200, 200);
		points = new ArrayList<Point>();
		c = 0;

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Point temp = new Point(0, 0);
		int cnt = c;
		for (int i = 0; i < 10; i++) {
			temp = points.get((cnt++)%10);
			g.drawLine(temp.x - 5, temp.y, temp.x + 5, temp.y);
			g.drawLine(temp.x, temp.y - 5, temp.x, temp.y + 5);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// g.drawString((p.x + " , " + p.y), (p.x - 10), (p.y - 10));
	}

	public static void main(String[] args) throws InterruptedException {
		Main test = new Main();
		Random r = new Random();
		while (true) {
			test.p.x = 190 + r.nextInt(20);
			test.p.y = 190 + r.nextInt(20);
			test.points.add(test.c++, test.p);
			if (test.c >= 10) {
				test.c = 0;
			}
			test.repaint();
			Thread.sleep(500);
		}
	}
}