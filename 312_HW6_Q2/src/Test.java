import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) {
		Runnable r;
		try {
			r = new Analize("/home/shihab/workspace/312_HW6_Q2/src/in.txt");
			Thread t = new Thread(r, "File Analysis");
			t.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
