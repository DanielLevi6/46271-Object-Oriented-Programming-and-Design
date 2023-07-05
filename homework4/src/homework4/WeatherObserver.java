package homework4;

/** The WeatherObserver interface is an interface for user-defined weather observers.
*
* The class provides a method to update the observer's state.
*
*/
public interface WeatherObserver {
    // Abstraction Function:
    // An interface for observing the weather data
	// Desired observer implementation must fulfill the update method requirements.

	/**
	 * Updating the weather
	 * @param temperature - the current temperature
	 * @param humidity - the current humidity
	 * @param air_pressure - the current air pressure
	 * 
	 * @requires humidity >= 0
	 * @effects updating the data according to the current weather values which has been received
	 */
	public void update(double temperature, double humidity, double air_pressure);
}
