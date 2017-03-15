class DisplayWeather implements Runnable {
	Weather weather;
	String city;

	public DisplayWeather(String city, Weather weather) {
		super();
		this.city = city;
		this.weather = weather;
	}

	@Override
	public void run() {
		weather.printWeatherData(city);
	}
}
