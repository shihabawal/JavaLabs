import java.io.*;


public class Client {
	
	public static void main(String[] args)   {
		String Ifile = "/home/shihab/workspace/312_HW5Q3/src/in.txt";
		String Ofile = "/home/shihab/workspace/312_HW5Q3/src/out.txt";
		try {
			FrenchRead in = new FrenchDataInputStream(new FileInputStream(Ifile));
			FrenchWrite out = new FrenchDataOutputStream(new FileOutputStream(Ofile));
			int lire = in.lire();
			while (lire != -1){
				out.ecrire(lire);
				lire = in.lire();
			}
			out.rougir();
			out.fin();
			in.fin();
			System.out.println("Fin!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}