import java.io.*;

public class Test {

	public static void main(String[] args) {
		InputStream fis;
		try {
			fis = new FileInputStream("/home/shihab/workspace/312_HW6/src/in.txt");
			OutputStream fos = new FileOutputStream("/home/shihab/workspace/312_HW6/src/out.txt");
			CopyThread tr = new CopyThread(fis, fos, "Copy thread");
			Thread t = new Thread(tr);
			t.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
