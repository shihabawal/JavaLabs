import java.util.Random;

class Weather {

	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTemp() {
		return new Random().nextInt(50);
	}

	public int windSpeed() {
		return new Random().nextInt(60);
	}

	public int humidity() {
		return new Random().nextInt(100);
	}

	synchronized public void printWeatherData(String city) {
		System.out.println("City = " + city);
		int temp = getTemp();
		deviceDelay(10);
		System.out.println("Temp = " + temp);
		int speed = windSpeed();
		deviceDelay(10);
		System.out.println("Wind speed =" + speed);
		int humid = humidity();
		deviceDelay(10);
		System.out.println("Humidity = " + humid);

	}

	public void deviceDelay(int msecs)// delay is in milli seconds
	{
		try {
			Thread.sleep(msecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
