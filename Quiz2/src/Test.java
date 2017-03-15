import java.io.*;

public class Test {

	public static void main(String[] args) {
		String Ofile = "/home/shihab/workspace/Quiz2/out.txt";
		DataOutputStream ofs;
		try {
			ofs = new DataOutputStream(new FileOutputStream(Ofile));
			Logical out = new Logical();
			boolean[] vals = { true, false, false, true, false, true };
			for (int i = 0; i < vals.length; i++) {
				out.write(ofs, vals[i]);
			}
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
