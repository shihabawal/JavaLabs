public class PrintWeather {
	public static void main(String args[]) {
		Weather wd = new Weather();
		DisplayWeather sharjah = new DisplayWeather("Sharjah", wd);
		DisplayWeather dubai = new DisplayWeather("Dubai", wd);
		Thread t1 = new Thread(sharjah);
		Thread t2 = new Thread(dubai);
		t1.start();
		t2.start();
	}

}