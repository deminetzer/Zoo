package animals;
import diet.IDiet;
import diet.Omnivore;
import mobility.Point;
import privateutil.Roar;
import utilities.MessageUtility;

/**
 * A class that defines a Bear.
 * @version April 2022
 * @author Demi Netzer
 */
public class Bear extends Roar{

	private String furColor; // the color of the bear's fur
	private static final Point default_p = new Point(100,5); // default location 
	private static final double default_w = 308.2; // default weight
	private static final String default_far = "GRAY"; // default far color
	private static final IDiet default_d = new Omnivore(); // default diet of a bear

	
	/**
	 * Constructor of a Bear 
	 * @param name
	 * 			- name of the bear
	 */
	public Bear(String name) {
		super(name, default_p, default_w, default_d);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
		this.setFarColor(default_far);
	}
	
	
	/**
	 * Constructor of a Bear 
	 * @param name
	 * 			- name of the bear
	 * @param p
	 * 			- location of the bear
	 */
	public Bear(String name, Point p) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), default_w, default_d);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
		this.setFarColor(default_far);
	}

	/**
	 * Constructor of a Bear 
	 * @param name
	 * 			- name of the bear
	 * @param p
	 * 			- location of the bear
	 * @param w
	 * 			- weight of the bear
	 * @param farColor
	 * 			- bear's fur color
	 */
	public Bear(String name, Point p, double w, String farColor) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), (w > 0) ? w : default_w, default_d);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
		if (farColor.contentEquals("BLACK") ||
				farColor.contentEquals("WHITE") ) {
			this.setFarColor(farColor);
		}
		else {
			this.setFarColor(default_far);
		}
	}
	
	/**
	 * A method that returns the bear's fur color
	 * @return fur color
	 */
	public String getFarColor() {
		MessageUtility.logGetter(this.getName(), "getFarColor", this.furColor);
		return this.furColor;
	}
	
	/**
	 * A method that defines a new fur color for the bear.
	 * @param s
	 * 			- new fur color
	 * @return If the setting was performed : true,
	 * 		   Otherwise : false.
	 */
	public boolean setFarColor(String far) {
		if (far.contentEquals("BLACK") || 
				far.contentEquals("WHITE") || 
				far.contentEquals("GRAY") ) {
			this.furColor = far;
			MessageUtility.logSetter(this.getName(), "setFarColor", far, true);
			return true;
		}
		MessageUtility.logSetter(this.getName(), "setFarColor", far, false);
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see privateutil.Roar#roar
	 */
	@Override
	public void roar() {
		MessageUtility.logSound(this.getName(), "Stands on its hind legs, roars and scratches its belly");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Bear] : " + this.getName();
	}
}
