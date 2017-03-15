import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		try {
			String Ifile = "/home/shihab/workspace/312_HW5/src/planet.txt";
			FileInputStream in = new FileInputStream(Ifile);
			System.out.println("Output from System.in:");
			printPlanetDetails(System.in);
			System.out.println("Output from file:");
			printPlanetDetails(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void printPlanetDetails(InputStream is) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		//ascii table character 0 is 48
		int num = in.read()-48;
		in.readLine();
		for (int i=0; i<num; i++){
			String line = in.readLine();
			System.out.println(line);
		}
	}
}
