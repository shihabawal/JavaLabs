import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_Lab7_Q6a/planetobject.txt";
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(Ifile));
			while (true) {
				Planet p = null;
				p = (Planet) in.readObject();
				System.out.println("Planet: [" + p + "] Recovered!");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("End of Objects");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
