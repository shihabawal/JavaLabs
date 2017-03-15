import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		String Ifile = "/home/shihab/workspace/312_HW5Q2/src/input.txt";
		try {
			BufferedReader in = new BufferedReader(new FileReader(Ifile));
			String line = in.readLine();
			int normalNo = 0, probationNo = 0;
			int num = Integer.parseInt(line);
			Student[] s = new Student[num];
			for (int i = 0; i < num; i++) {
				line = in.readLine();
				// split at ','
				String tokens[] = line.split(",");
				if (tokens[2].compareTo("normal") == 0)
					normalNo++;
				else
					probationNo++;
				s[i] = new Student(Integer.parseInt(tokens[0]),
						Integer.parseInt(tokens[1]), tokens[2]);
			}

			NormalStudent[] n = new NormalStudent[normalNo];
			ProbationaryStudent[] p = new ProbationaryStudent[probationNo];
			int j = 0, k = 0;
			for (int i = 0; i < num; i++) {
				if (s[i].getType().compareTo("normal") == 0) {
					n[j] = new NormalStudent(s[i].getId(), s[i].getAbsence());
					j++;
				} else {
					p[k] = new ProbationaryStudent(s[i].getId(),
							s[i].getAbsence());
					k++;
				}
			}
			System.out.println("Normal Students:");
			for (int i = 0; i < normalNo; i++) {
				System.out.println(n[i]);
			}
			System.out.println("Normal Students who exceeds absences:");
			for (int i = 0; i < normalNo; i++) {
				if (n[i].exceedsAbsences())
					System.out.println(n[i]);
			}
			System.out.println("\nProbation Students:");
			for (int i = 0; i < probationNo; i++) {
				System.out.println(p[i]);
			}
			System.out.println("Probaion Students who exceeds absences:");
			for (int i = 0; i < probationNo; i++) {
				if (p[i].exceedsAbsences())
					System.out.println(p[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
