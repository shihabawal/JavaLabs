import java.io.*;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_Lab5_Q2/planet.txt";
		try {
			Planet p[] = new Planet[9];
			int heaviestI = 0, maxDistI = 0;
			double heaviest = Double.MIN_VALUE, maxDist = Double.MIN_VALUE;
			BufferedReader in = new BufferedReader(new FileReader(Ifile));
			String line = in.readLine();
			for (int i = 0; line != null; i++) {
				String[] tokens = line.split(" ");
				p[i] = new Planet(tokens[0], Double.parseDouble(tokens[1]),
						Double.parseDouble(tokens[2]),
						Double.parseDouble(tokens[3]));
				line = in.readLine();
				if (p[i].getOrbit()>maxDist){
					maxDist = p[i].getOrbit();
					maxDistI = i;
				}
				if (p[i].getMass()>heaviest){
					heaviest = p[i].getMass();
					heaviestI = i;
				}
			}
			System.out.println("The planet " + p[heaviestI].getName() + " is the heaviest of all planets having mass.");
			System.out.println("The planet " + p[maxDistI].getName() + "  has maximum distance from the sun.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
