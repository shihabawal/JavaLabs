import java.io.*;

public class Test {

	public static void main(String[] args) {
		String Ifilename = "/home/shihab/workspace/312_HW4/in.txt";
		try {
			BufferedReader in = new BufferedReader(new FileReader(Ifilename));
			String line = in.readLine();
			while (line != null) {
				int sum = 0;
				for (int i = 0; i < line.length(); i++) {
					if (Character.isDigit(line.charAt(i))) {
						sum += ((int) line.charAt(i)) - 48;
					}
				}
				System.out.println("Sum of integers in " + line + " is " + sum);
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
