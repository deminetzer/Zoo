package animals;

import diet.Herbivore;
import diet.IDiet;
import mobility.Point;
import privateutil.Chew;
import utilities.MessageUtility;

public class Turtle extends Chew {

	private int age;
	private static final Point default_p = new Point(80,0); // default location of turtle
	private static final double default_w = 1; // default weight of turtle
	private static final IDiet default_d = new Herbivore();  // default diet of turtle
	private static final int default_age = 1; // default age of turtle
	
	/**
	 * Constructor of a turtle
	 * @param name
	 * 			- name of the turtle
	 */
	public Turtle(String name) {
		super(name, default_p, default_w, default_d);
		this.setAge(default_age);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}
	
	
	/**
	 * Constructor of a turtle 
	 * @param name
	 * 			- name of the turtle
	 * @param p
	 * 			- location of the turtle
	 */
	public Turtle(String name, Point p) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), default_w, default_d);
		this.setAge(default_age);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}
	

	/**
	 * Constructor of a turtle
	 * @param name
	 * 			- name of the turtle
	 * @param p
	 * 			- location of the turtle
	 * @param w
	 * 			- weight of the turtle
	 * @param age
	 * 			- age of the turtle
	 */	
	public Turtle(String name, Point p, double w, int age) {
		super(name, (Point.cheackBounderies(p) ? p : default_p), (w > 0) ? w : default_w, default_d);
		if (age >= 0 && age <= 500) {
			this.setAge(age);
		}
		else {
			this.setAge(default_age);
		}
		MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
	}
	
	/**
	 * A method that returns the turtle's age
	 * @return age
	 */
	public int getAge() {
		MessageUtility.logGetter(this.getName(), "getAge", this.age);
		return this.age;
	}
	
	/**
	 * A method that defines a new age for the turtle.
	 * @param age
	 * 			- new age
	 * @return If the setting was performed : true,
	 * 		   Otherwise : false.
	 */
	public boolean setAge(int age) {
		if (age >= 1 && age <= 500) {
			this.age = age;
			MessageUtility.logSetter(this.getName(), "setAge", age, true);
			return true;
		}
		MessageUtility.logSetter(this.getName(), "setAge", age, false);
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see privateutil.Chew#chew
	 */
	@Override
	public void chew() {
		MessageUtility.logSound(this.getName(),"Retracts its head in then eats quietly");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Turtle] : " + this.getName();
	}
}
