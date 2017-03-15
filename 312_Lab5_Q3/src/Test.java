/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_Lab5_Q3/in.txt";
		String Ofile = "/home/shihab/workspace/312_Lab5_Q3/out.txt";
		
		try {
			FileInputStream in = new FileInputStream(Ifile);
			Encrypt out = new Encrypt(Ofile);
			int read = in.read();
			while (read != -1){
				out.write(read);
				read = in.read();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
 */

import java.io.*;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_Lab5_Q3/out.txt";
		try {
			Decrypt in = new Decrypt(Ifile);
			int read = in.read();
			while (read != -1) {
				System.out.print((char)read);
				read = in.read();
			}
			System.out.println("");
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
