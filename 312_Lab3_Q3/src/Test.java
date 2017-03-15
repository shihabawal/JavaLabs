import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
				"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
				"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		char c = 'a';
		System.out.print("Enter capital alphabet: ");
		try {
			c = (char)System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Morse code:  " + morseCode[(int)c-65]);
	}

}
