package question2;

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
	 * @param new_temperature - the current temperature
	 * @param new_humidity - the current humidity
	 * @param new_air_pressure - the current air pressure
	 * 
	 * @requires humidity >= 0
	 * @effects updating the data according to the current weather values which has been received
	 */
	public void update(double new_temperature, double new_humidity, double new_air_pressure);
}
