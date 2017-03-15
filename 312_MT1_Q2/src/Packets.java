import java.util.Random;

public class Packets {
	private double num1, num2;
	private String s;
	
	public Packets(double num1, double num2, String s) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.s = s;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	public void ramdomPacket(){
		Random r = new Random();
		this.num1 = r.nextDouble();
		this.num2 = r.nextDouble();
		this.s = "Random";
	}
}
