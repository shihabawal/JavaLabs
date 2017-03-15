import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyComponents implements ActionListener {
	Frame f;

	JPanel panelTop;
	JPanel panelBottom;

	JButton add;
	JButton sub;
	JButton mul;
	JButton div;

	JLabel fNumL;
	JLabel sNumL;
	JLabel resultL;

	JTextField fNum;
	JTextField sNum;
	JTextField result;

	GridLayout frameLayout;

	public MyComponents() {
		fNumL = new JLabel("First Number");
		fNumL.setSize(25, 10);
		sNumL = new JLabel("Second Number");
		sNumL.setSize(25, 10);
		resultL = new JLabel("Result");
		resultL.setSize(25, 10);

		fNum = new JTextField();
		fNum.setSize(25, 10);
		sNum = new JTextField();
		sNum.setSize(25, 10);
		result = new JTextField();
		result.setSize(25, 10);

		add = new JButton("+");
		add.addActionListener(this);
		sub = new JButton("-");
		sub.addActionListener(this);
		mul = new JButton("*");
		mul.addActionListener(this);
		div = new JButton("/");
		div.addActionListener(this);

		f = new Frame();

		frameLayout = new GridLayout(2, 1);
		panelTop = new JPanel(new GridLayout(3, 2));
		panelTop.setSize(400, 250);
		panelBottom = new JPanel(new GridLayout(1, 4));
		panelBottom.setSize(400, 50);

		panelTop.add(fNumL);
		panelTop.add(fNum);
		panelTop.add(sNumL);
		panelTop.add(sNum);
		panelTop.add(resultL);
		panelTop.add(result);

		panelBottom.add(add);
		panelBottom.add(sub);
		panelBottom.add(mul);
		panelBottom.add(div);

		f.setLayout(frameLayout);
		f.add(panelTop);
		f.add(panelBottom);
		f.setSize(400, 300);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			double num1 = Double.parseDouble(fNum.getText());
			double num2 = Double.parseDouble(sNum.getText());
			result.setText(Double.toString(num1 + num2));
		} else if (ae.getSource() == sub) {
			double num1 = Double.parseDouble(fNum.getText());
			double num2 = Double.parseDouble(sNum.getText());
			result.setText(Double.toString(num1 - num2));
		} else if (ae.getSource() == mul) {
			double num1 = Double.parseDouble(fNum.getText());
			double num2 = Double.parseDouble(sNum.getText());
			result.setText(Double.toString(num1 * num2));
		} else if (ae.getSource() == div) {
			double num1 = Double.parseDouble(fNum.getText());
			double num2 = Double.parseDouble(sNum.getText());
			result.setText(Double.toString(num1 / num2));
		}
	}
}