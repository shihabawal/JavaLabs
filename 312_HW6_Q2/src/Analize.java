import java.io.*;

public class Analize implements Runnable {

	DataInputStream in;

	public Analize(String fname) throws FileNotFoundException {
		in = new DataInputStream(new FileInputStream(fname));
	}

	public void run() {
		try {
			int characters = 0, lines = 0, words = 0;
			int read;
			do {
				read = in.read();
				String s = new String();
				
				if ((char) read == ' ') {
					words++;
				}
				else if ((char) read == '\n') {
					lines++;
					words++;
				}
				else
					characters++;
			} while (read != -1);
			characters--;//for the last read = -1
			System.out.println("Chars = " + characters);
			System.out.println("Words = " + words);
			System.out.println("Lines = " + lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
