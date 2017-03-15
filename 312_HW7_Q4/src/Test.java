import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {
		String Ofile = "/home/shihab/workspace/312_HW7_Q4/src/data.txt";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(Ofile));
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(Ofile));
			RandomGen r1 = new RandomGen("Thread 1");
			System.out.println("Serializable and runnable object created");
			r1.writeObject(os);
			System.out.println("Serializable and runnable object created is getting written to the file");
			RandomGen r2 = new RandomGen("Thread 2");
			r2.readObject(is);
			System.out.println("Serializable and runnable object is getting read from the file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e){
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
