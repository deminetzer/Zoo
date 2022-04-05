package animals;

import diet.Herbivore;
import diet.IDiet;
import mobility.Point;
import privateutil.Chew;
import utilities.MessageUtility;

public class Giraffe extends Chew{

	private double neckLength; 
	private static final Point default_p = new Point(50,0); // default location of giraffe
	private static final double default_w = 450; // default weight of giraffe
	private static final double default_neck = 1.5; // default neck length of giraffe
	private static final IDiet default_d = new Herbivore();  // default diet of giraffe

	/**
	 * Constructor of a giraffe
	 * @param name
	 * 			- name of the giraffe
	 */
	public Giraffe(String name) {
		super(name, default_p, default_w, default_d);
		this.neckLength = default_neck;
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}
	
	/**
	 * Constructor of a giraffe 
	 * @param name
	 * 			- name of the giraffe
	 * @param p
	 * 			- location of the giraffe
	 */
	public Giraffe(String name, Point p) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), default_w, default_d);
		this.neckLength = default_neck;
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}

	/**
	 * Constructor of a giraffe
	 * @param name
	 * 			- name of the giraffe
	 * @param p
	 * 			- location of the giraffe
	 * @param w
	 * 			- weight of the giraffe
	 * @param neck
	 * 			- neck length of the giraffe
	 */	
	public Giraffe(String name, Point p, double w, double neck) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), (w > 0) ? w : default_w, default_d);
		if (neck >= 1 && neck <= 2.5) {
			this.neckLength = neck;
		}
		else {
			this.neckLength = default_neck;
		}
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}
	
	/**
	 * A method that returns the giraffe's neck length
	 * @return neck length
	 */
	public double getNeckLength() {
		MessageUtility.logGetter(this.getName(), "getNeckLength", String.format("%.2f", this.neckLength));
		return this.neckLength;
	}
	
	
	/**
	 * A method that defines a new neck length for the giraffe.
	 * @param neck
	 * 			- new neck length
	 * @return If the setting was performed : true,
	 * 		   Otherwise : false.
	 */
	public boolean setNeckLength(double neck) {
		if (neck >= 1 && neck <= 2.5) {
			this.neckLength = neck;
			MessageUtility.logSetter(this.getName(), "setNeckLength", String.format("%.2f", this.neckLength), true);
			return true;
		}
		MessageUtility.logSetter(this.getName(), "setNeckLength", String.format("%.2f", this.neckLength), false);
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see privateutil.Chew#chew
	 */
	@Override
	public void chew() {
		MessageUtility.logSound(this.getName(),"Bleats and Stomps its legs, then chews");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Giraffe] : " + this.getName();
	}
	
}