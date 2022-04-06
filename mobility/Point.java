package mobility;


/**
 * A class that defines a location on a two-dimensional axis.
 * @version April 2022
 * @author Demi Netzer
 */
public class Point {
	private static final int x_start = 0; //minimum x
	private static final int x_end = 800; //maximum x 
	private static final int y_start = 0; //minimum y
	private static final int y_end = 600; //maximum y
	private int x;
	private int y;
	

	/**
	 * Constructor for Point object.
	 * @param x
	 * 			- x value
	 * @param y
	 * 			- y value
	 */
	public Point(int x ,int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * A method that returns the X value of the point.
	 * 
	 * @return X value of the point
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * A method that returns the Y value of the point.
	 * 
	 * @return Y value of the point
	 */
	public int getY() {
		return this.y;
	}	
	
	/**
	 * A method that returns "true" if a point is 
	 * in valid range.
	 * 
	 * @param pointToCheck
	 * 					- A point to check the correctness of its range.
	 * @return If the point is in a valid range: true.
	 *         Otherwise: false.
	 */
	public static boolean cheackBounderies(Point pointToCheck) {
		if (pointToCheck.getX() >= x_start && pointToCheck.getX() <= x_end
				&& pointToCheck.getY() >= y_start && pointToCheck.getY() <= y_end)
			return true;
		return false;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "(" + this.getX() + "," + this.getY() + ")";
	}
	
}
