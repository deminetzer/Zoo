package mobility;

/**
 * Interface that describes the functionality
 * of a location.
 * 
 * @version April 2022
 * @author Demi Netzer
 */
public interface ILocatable {
	
	/**
	 * A method that returns location.
	 * 
	 * @return Location - expressed by Point
	 */
	public Point getLocation();
	
	/**
	 * A method that defines a new location of
	 * the object.
	 * 
	 * @param p
	 * 			- new location 
	 * @return If the setting was made : true.
	 * 		   Otherwise : false.
	 */
	public boolean setLocation(Point p);

}
