package question2;

import java.util.*;

/** The WeatherData class is an abstract class that represents the most updated data about the weather.
*
* The class provides methods to add and remove WeatherObservers. In addition to a method for
* notifying the observers according to the current weather state.
*/
public abstract class WeatherData {
    // Abstraction Function:
	// Represents the weather data(the weather states which have been saved)
	// The observers are stored in a list
	// temperature represents the current temperature in the weather state
	// humidity represents the current humidity in the weather state
	// air_pressure represents the current air_pressure in the weather state

    // Representation invariant:
    //      observer_list != null
	//		humidity >= 0
    //      for every observer o in observer's list:
    //           o != null
	private List<WeatherObserver> observer_list;
	private double temperature;
	private double humidity;
	private double air_pressure;
	
	
	/**
	 * Constructs a new object
	 * 
	 * @effects Makes a new WeatherData object
	 */
	public WeatherData() {
		observer_list = new ArrayList<WeatherObserver>();
		temperature = 0;
		humidity = 0;
		air_pressure = 0;
		
		checkRep();
	}
	
	/**
	 * Adding a new observer to the observer list
	 * 
	 * @param observer - the user's observer which should be added to the object
	 * 
	 * @requires observer != null
	 * #modifies this
	 */
	public void addObserver(WeatherObserver observer) {
		checkRep();
		observer_list.add(observer);
		checkRep();
	}
	
	/**
	 * Removing an observer from the observer list
	 * 
	 * @param observer - the observer which should be removed from the object
	 * 
	 * @requires observer != null
	 * #modifies this
	 */
	public void removeObserver(WeatherObserver observer) {
		checkRep();
		observer_list.remove(observer);
		checkRep();
	}
	
	/**
	 * Notifying all the observers which have been stored in this object to update the weather state
	 * 
	 * @requires humidity >= 0
	 * @effects update of all the observers which are stored in the object
	 */
	public void notifyObserver() {
		checkRep();
		for (WeatherObserver observer : observer_list) {
			observer.update(this.temperature, this.humidity, this.air_pressure);
		}
		checkRep();
	}

	/**
	 * Setting the internal weather state according to the parameters that have been received
	 * 
	 * @param new_temperature - the current temperature
	 * @param new_humidity - the current humidity
	 * @param new_air_pressure - the current air pressure
	 * 
	 * @requires new_humidity >= 0
	 * @modifies this
	 * @effects update the state of the WeatherData
	 */
	public void setWeather(double new_temperature, double new_humidity, double new_air_pressure) {
		checkRep();
		this.temperature = new_temperature;
		this.humidity = new_humidity;
		this.air_pressure = new_air_pressure;
		this.notifyObserver();
		checkRep();
	}
	
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
        assert this.observer_list != null : "The observer list is null";
        assert this.humidity >= 0 : "Negative humidity is invalid";
        for (WeatherObserver observer : observer_list) {
        	assert observer != null : "There is an observer which is null";
        }
    }
}
