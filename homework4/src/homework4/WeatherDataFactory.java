package homework4;

import java.util.*;

/** The WeatherDataFactory class is used for creating new LocationWeatherData objects..
*
* This class provides a method for the create operation.
*/
public class WeatherDataFactory {
    // Abstraction Function:
    // 

    // Representation invariant:
    //      
	
	private Map<String, LocationWeatherData> location_weather_classes;
	
	public WeatherDataFactory() {
		location_weather_classes = new HashMap<String, LocationWeatherData>();
		checkRep()
	}
	
	public LocationWeatherData createLocationWeatherData(String new_location_name) {
		checkRep();
		LocationWeatherData new_location_weather_data = new LocationWeatherData(new_location_name);
		checkRep();
		return new_location_weather_data;
	}
	
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
        assert this.location_weather_classes != null : "The location list is null";
    }
}
