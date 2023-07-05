package homework4;

/** The LocationWeatherData class extends the WeatherData class and represents the most updated weather data in a specific location.
*
* In addition to WeatherData's methods, this class provides methods to set and get the location.
*/
public class LocationWeatherData extends WeatherData {
    // Abstraction Function:
	// Represents the weather data in a specific location(represented as a string)
	// Extends the WeatherData abstract class, therefore contains all its functionality
	//
	// The location name is represented by the "location" string

    // Representation invariant:
	//		location != null
	
	private String location;
	
	/**
	 * Constructs a new object
	 * 
	 * @param new_location - The location to be represented in that object
	 * 
	 * @requires new_location != null
	 * @effects Makes a new LocationWeatherData object with the name of the location
	 */
	public LocationWeatherData(String new_location) {
		checkRep();
		this.location = new_location;
		checkRep();
	}
	
	/**
	 * Returns the name of the object's location(which its weather we monitor
	 * 
	 * @return String which represents the name of the object's location
	 */
	public String getLocation() {
		checkRep();
		return this.location;
	}
	
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
        assert this.location != null : "Location's name is null";
    }
}
