package question2;

import java.util.*;

/** The WeatherDataFactory class is used for creating new LocationWeatherData objects..
*
* This class provides a method for the create operation.
*/
class WeatherDataFactory {
    // Abstraction Function:
    // This class is used as a Factory class, which creates objects of LocationWeatherData class
	// The objects are stored in a map, using the location name as a key, and the object instance as the value.
	// In case the same location's weather instance have been already created, no new instance will be created. The existing instance
	// will be returned to the user.

    // Representation invariant:
    //      location_weather_classes != null
	//		for a and b in location_weather_classes:
	//			a.location != b.location
	//		for {key:value} in location_weather_classes:
	//			key is String
	//			value is LocationWeatherData
	
	private static Map<String, LocationWeatherData> location_weather_classes = new HashMap<String, LocationWeatherData>();

	
	/**
	 * Creates a new instance of LocationWeatherData, in case there is no instance with the same location name.
	 * Otherwise, returns the same existing instance of the required location
	 * 
	 * @param new_location_name - A location name, which it's weather data we want to monitor
	 * @return the instance of LocationWeatherData of the specified location.
	 * 		   If there is an instance of this location, so this instance will be returned.
	 * 		   If not, so a new LocationWeatherData instance will be created and returned to the user
	 * 
	 * @requires new_location_name != null, new_location_name is a String
	 * @modifies this
	 * @effects creates a new instance of LocationWeatherData in case there is no existing one, and add it to the list
	 */
	public static LocationWeatherData createLocationWeatherData(String new_location_name) {
		checkRep();
		if (!location_weather_classes.containsKey(new_location_name)) {
			location_weather_classes.put(new_location_name, new LocationWeatherData(new_location_name));
		}
		
		checkRep();
		return location_weather_classes.get(new_location_name);	
	}
	
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private static void checkRep() {
        assert WeatherDataFactory.location_weather_classes != null : "The location list is null";
        // The condition-(for a and b in location_weather_classes: a.location != b.location) 
        // is implemented as the functionality of the HashMap
        for (Map.Entry<String, LocationWeatherData> map_entry : location_weather_classes.entrySet()) {
        	assert map_entry.getKey() instanceof String : "A key in the map is invalid(not a String)";
        	assert map_entry.getValue() instanceof LocationWeatherData : "A value in the map is invalid(not a LocationWeatherData)";
        }
    }
}
