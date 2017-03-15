import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_Lab7_Q6a/planet.txt";
		String Ofile = "/home/shihab/workspace/312_Lab7_Q6a/planetobject.txt";
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(Ifile));
			FileOutputStream fos = new FileOutputStream(Ofile);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			String line = in.readLine();
			while (line != null){
				String[] tokens = line.split(" ");
				Planet p = new Planet(tokens[0], 
						Double.parseDouble(tokens[1]), 
						Double.parseDouble(tokens[2]), 
						Double.parseDouble(tokens[3]));
				out.writeObject(p);
				line = in.readLine();
				System.out.println("Planet: [" + p + "] Saved!");
			}
			in.close();
			fos.flush();
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
