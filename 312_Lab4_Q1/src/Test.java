import java.io.*;

public class Test {

	public static void main(String[] args) {
		String Ifilename = "/home/shihab/workspace/312_Lab4_Q1/binary.txt";
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(Ifilename));
			String name = in.readUTF();
			do {
				System.out.println(name + " " + in.readDouble() + " "  + in.readDouble() + " "  + in.readDouble());
				name = in.readUTF();
			}while (true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Done!");
		}
	}
}
