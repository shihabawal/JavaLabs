import java.io.IOException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Snooper s = new Snooper(System.in);
		for (int i=0; i<5; i++){
			char a = s.readchar();
			int ascii = (int) a;
			if (a != 'a'){
				ascii = -2;
				a = '?';
			}
			System.out.println("read: " + a + " whose ascii code is " + ascii);
		}
	}

}
