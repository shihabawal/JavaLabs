import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_Lab5_Q4/src/in.txt";
		String Ofile = "/home/shihab/workspace/312_Lab5_Q4/src/out.txt";
		try {
			CovertToLowerCase in = new CovertToLowerCase(new FileInputStream(Ifile));
			FileOutputStream out = new FileOutputStream(Ofile);
			int read = in.read();
			while(read != -1){
				out.write(read);
				read = in.read();
			}
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
