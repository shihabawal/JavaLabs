import java.util.Random;

public class PhoneBoth {

	private boolean inUse;

	public PhoneBoth() {
		inUse = false;
	}

	public void makeCall(String theCaller) throws MyException {
		if (inUse == true) {
			throw new MyException();
		} else {
			System.out.println(theCaller + " is locking Phonebooth");
			inUse = true;
			System.out.println(theCaller + " is making a call");
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(1000));
				inUse = false;
				System.out.println(theCaller + " is opening Phonebooth");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
