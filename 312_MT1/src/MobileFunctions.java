public class MobileFunctions extends Mobile {

	String number, song, artist;

	public void call(String number) {
		System.out.println("Calling number " + number);
	}

	public void playSong(String song, String artist) {
		System.out.println("Playing song " + song + " by " + artist);
	}

	public void pauseSong(String song, String artist) {
		System.out.println("Pausing song " + song + " by " + artist);
	}

	public void recieveCall() {
		System.out.println("Receiving call ...");
	}
}
