package question2;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starts the test");

		System.out.println("Initializes the LocationWeatherData");
		LocationWeatherData tiberias_data = WeatherDataFactory.createLocationWeatherData("Tiberias");
		LocationWeatherData tel_aviv_data = WeatherDataFactory.createLocationWeatherData("Tel Aviv ya habibi Tel Aviv");
		LocationWeatherData haifa_data = WeatherDataFactory.createLocationWeatherData("Haifa");
		LocationWeatherData second_tiberias_data = WeatherDataFactory.createLocationWeatherData("Tiberias");

		System.out.println("Starts the test");
		WeatherObserver tiberias_observer = new WeatherObserver() {
			double temperature, humidity, air_pressure;
			
			public void update(double new_temperature, double new_humidity, double new_air_pressure) {
				this.temperature = new_temperature;
				this.humidity = new_humidity;
				this.air_pressure = new_air_pressure;
				
				System.out.println("Got an update");
				System.out.println(this.toString());
			}
			
			public String toString() {
				return "Tiberias: Temperature - " + this.temperature + ", Humidity - " + this.humidity + ", Air pressuere - " + this.air_pressure;
			}
		};		
		tiberias_data.addObserver(tiberias_observer);
		
		WeatherObserver tel_aviv_observer = new WeatherObserver() {
			double temperature, humidity, air_pressure;
			
			public void update(double new_temperature, double new_humidity, double new_air_pressure) {
				this.temperature = new_temperature;
				this.humidity = new_humidity;
				this.air_pressure = new_air_pressure;
				
				System.out.println("Got an update");
				System.out.println(this.toString());
			}
			
			public String toString() {
				return "Tel Aviv Temperature - " + this.temperature + ", Humidity - " + this.humidity + ", Air pressuere - " + this.air_pressure;
			}
		};		
		tel_aviv_data.addObserver(tel_aviv_observer);
		
		WeatherObserver haifa_observer = new WeatherObserver() {
			double temperature, humidity, air_pressure;
			
			public void update(double new_temperature, double new_humidity, double new_air_pressure) {
				this.temperature = new_temperature;
				this.humidity = new_humidity;
				this.air_pressure = new_air_pressure;
				
				System.out.println("Got an update");
				System.out.println(this.toString());
			}
			
			public String toString() {
				return "Haifa: Temperature - " + this.temperature + ", Humidity - " + this.humidity + ", Air pressuere - " + this.air_pressure;
			}
		};	
		haifa_data.addObserver(haifa_observer);
		
		WeatherObserver second_tiberias_observer = new WeatherObserver() {
			double temperature, humidity, air_pressure;
			
			public void update(double new_temperature, double new_humidity, double new_air_pressure) {
				this.temperature = new_temperature;
				this.humidity = new_humidity;
				this.air_pressure = new_air_pressure;
				
				System.out.println("Got an update");
				System.out.println(this.toString());
			}
			
			public String toString() {
				return "Tiberias again: Temperature - " + this.temperature + ", Humidity - " + this.humidity + ", Air pressuere - " + this.air_pressure;
			}
		};
		second_tiberias_data.addObserver(second_tiberias_observer);

		System.out.println("\nUpdate 1- " + tiberias_data.getLocation());
		tiberias_data.setWeather(28.5, 70.0, 50.0);
		System.out.println("\nUpdate 2- " + tel_aviv_data.getLocation());
		tel_aviv_data.setWeather(27.0, 65.0, 70.0);
		System.out.println("\nUpdate 3- " + haifa_data.getLocation());
		haifa_data.setWeather(23.5, 50.0, 100.0);
		System.out.println("\nUpdate 4- " + second_tiberias_data.getLocation());
		second_tiberias_data.setWeather(29.0, 72.0, 25.0);
		
	}
}
