package animals;
import java.lang.Math;
import diet.Carnivore;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import privateutil.Roar;
import utilities.MessageUtility;

/**
 * A class that defines a Lion.
 * @version April 2022
 * @author Demi Netzer
 */
public class Lion extends Roar {
	
	private int scarCount; // number of scars
	private static final int default_s = 0; // default number of scars
	private static final Point default_p = new Point(20,0); // default location of a lion
	private static final double default_w = 408.2; // default weight of a lion
	private static final IDiet default_d = new Carnivore(); // default diet of a lion
	
	/**
	 * Constructor of a Lion 
	 * @param name
	 * 			- name of the lion
	 */
	public Lion(String name) {
		super(name, default_p, default_w, default_d);
		this.setScarCount(default_s);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}
	
	
	/**
	 * Constructor of a Lion 
	 * @param name
	 * 			- name of the lion
	 * @param p
	 * 			- location of the lion
	 */
	public Lion(String name, Point p) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), default_w, default_d);
		this.setScarCount(default_s);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}

	
	/**
	 * Constructor of a Lion 
	  @param name
	 * 			- name of the lion
	 * @param p
	 * 			- location of the lion
	 * @param w
	 * 			- weight of the lion
	 * @param scars
	 * 			- number of scars 
	 */			 
	public Lion(String name, Point p, double w, int scars) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), (w > 0) ? w : default_w, default_d);
		this.scarCount = ( (scars > 0) ? scars : default_s);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}

	/**
	 * A method that returns the number of scars of the lion
	 * @return number of scars
	 */
	public int getScarCount() {
		MessageUtility.logGetter(this.getName(), "getScarCount", this.scarCount);
		return this.scarCount;
	}
	
	/**
	 * A method that defines a new number of scars for the lion.
	 * @param s
	 * 			- new number of scars
	 * @return If the setting was performed : true,
	 * 		   Otherwise : false.
	 */
	public boolean setScarCount(int s) {
		if (s < 0) {
			MessageUtility.logSetter(this.getName(), "setScarCount", s, false);
			return false;
		}
		this.scarCount = s;
		MessageUtility.logSetter(this.getName(), "setScarCount", s, true);
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IEdible#getFoodtype
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
		return EFoodType.NOTFOOD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see privateutil.Roar#roar
	 */
	@Override
	public void roar() {
		MessageUtility.logSound(this.getName(),"Roars, then stretches and shakes its mane");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see animals.Animal#eat
	 */
	@Override
	public boolean eat(IEdible diet) {
		if (super.eat(diet)) {
			if (Math.random() > 0.5) {
				this.setScarCount(this.getScarCount()+1);
			}
			return true;
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Lion] : " + this.getName();
	}
}
