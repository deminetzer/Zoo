package mobility;
import java.lang.Math;

/**
 * An abstract class that defines motion in space.
 * 
 * @version April 2022
 * @author Demi Netzer
 */
public abstract class Mobile implements ILocatable {
	private Point location; //Current location
	private double totalDistance; //Distance the object traveled
	
	/**
	 * constructor for Mobile object.
	 * @param p
	 * 			- location
	 */
	public Mobile(Point p) {
		this.location = new Point(p.getX(), p.getY());			
		this.totalDistance = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation
	 */
	@Override
	public Point getLocation() {
		return this.location;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation
	 */
	@Override
	public boolean setLocation(Point p) {
		if (Point.cheackBounderies(p)) {
			this.location = p;
			return true;
		}
		return false;
	}
	
	/**
	 * A method that returns the total 
	 * distance the object has traveled.
	 * 
	 * @return Total distance the object has traveled.
	 */
	public double getTotalDistance() {
		return this.totalDistance;
	}
	
	/** 
	 * A method that increases the total distance
	 * after movement.
	 * @param d 
	 * 			- additional distance.
	 */
	public void addTotalDistance(double d) {
		this.totalDistance += d;
	}
	
	/**
	 * A method that calculates the distance between the
	 * current location and a new location.
	 * @param other
	 * 				- new location
	 * @return The distance between the two locations.
	 */
	public double calcDistance(Point other) {
		double x = this.getLocation().getX() - other.getX();
		double y = this.getLocation().getY() - other.getY();
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));	
	}
	
	/**
	 * A method that moves the object to a new location.
	 * 
	 * @param p
	 * 			- new location
	 * 
	 * @return If the new location is valid: The distance between 
	 * 		   the current location and the new location.
			   Otherwise: 0
	 */
	public double move(Point p) {
		if (!Point.cheackBounderies(p)) {
			return 0;
		}
		double dis = this.calcDistance(p);
		this.addTotalDistance(dis);
		this.setLocation(p); // Point is immutable 
		return dis;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Mobile] : " + this.getLocation() + "," + this.getTotalDistance();
	}
}
