import java.io.*;

public class Test {

	public static void main(String[] args) {
		String Ifile1 = "/home/shihab/workspace/312_Lab5_Q1/test1.txt";
		String Ifile2 = "/home/shihab/workspace/312_Lab5_Q1/test2.txt";
		String Ofile = "/home/shihab/workspace/312_Lab5_Q1/merge.txt";
		
		try {
			FileInputStream in1 = new FileInputStream(Ifile1);
			FileInputStream in2 = new FileInputStream(Ifile2);
			FileOutputStream out = new FileOutputStream(Ofile);	
			SequenceInputStream sis = new SequenceInputStream(in1, in2);
			int read = sis.read();
			while (read != -1){
				out.write(read);
				read = sis.read();
			}
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
