package animals;

import diet.Herbivore;
import diet.IDiet;
import mobility.Point;
import privateutil.Chew;
import utilities.MessageUtility;

public class Elephant extends Chew{

	private double trunkLength; // elephant's trunk length
	private static final Point default_p = new Point(50,90); // default location of elephant
	private static final double default_w = 500; // default weight of elephant
	private static final double default_trunk = 1; // default trunk length of elephant
	private static final IDiet default_d = new Herbivore(); // default diet of elephant
	
	/**
	 * Constructor of an elephant 
	 * @param name
	 * 			- name of the elephant
	 */
	public Elephant(String name) {
		super(name, default_p, default_w, default_d);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
		this.setTrunkLength(default_trunk);
	}

	/**
	 * Constructor of an elephant 
	 * @param name
	 * 			- name of the elephant
	 * @param p
	 * 			- location of the elephant
	 */
	public Elephant(String name, Point p) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), default_w, default_d);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
		this.setTrunkLength(default_trunk);
	}

	/**
	 * Constructor of an elephant 
	 * @param name
	 * 			- name of the elephant
	 * @param p
	 * 			- location of the elephant
	 * @param w
	 * 			- weight of the elephant
	 * @param trunk
	 * 			- trunk length of the elephant
	 */
	public Elephant(String name, Point p, double w, double trunk) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), (w > 0) ? w : default_w, default_d);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
		if (trunk >= 0.5 && trunk <= 3) {
			this.setTrunkLength(trunk);
		}
		else {
			this.setTrunkLength(default_trunk);
		}
	}
	
	/**
	 * A method that returns the elephant's trunk length
	 * @return trunk length
	 */
	public double getTrunkLength() {
		MessageUtility.logGetter(this.getName(), "getTrunkLength", String.format("%.2f", this.trunkLength));
		return this.trunkLength;
	}
	
	/**
	 * A method that defines a new trunk length for the elephant.
	 * @param trunk
	 * 			- new trunk length
	 * @return If the setting was performed : true,
	 * 		   Otherwise : false.
	 */
	public boolean setTrunkLength(double trunk) {
		if (trunk >= 0.5 && trunk <= 3) {
			this.trunkLength = trunk;
			MessageUtility.logSetter(this.getName(), "setTrunkLength", String.format("%.2f", this.trunkLength), true);
			return true;
		}
		MessageUtility.logSetter(this.getName(), "setTrunkLength", String.format("%.2f", this.trunkLength), true);		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see privateutil.Chew#chew
	 */
	@Override
	public void chew() {
		MessageUtility.logSound(this.getName(),"Trumpets with joy while flapping its ears, then chews");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Elephant] : " + this.getName();
	}
}