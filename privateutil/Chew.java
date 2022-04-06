package privateutil;

import animals.Animal;
import diet.IDiet;
import mobility.Point;
import utilities.MessageUtility;

/**
 * A class that defines animals that chews.
 * @version April 2022
 * @author Demi Netzer
 */
public abstract class Chew extends Animal{

	/**
	 * Constructor 
	 * @param name
	 * 			- name of the animal that chews
	 * @param p
	 * 			- location of the animal that chews
	 * @param w
	 * 			- weight of the animal that chews
	 * @param d
	 * 			- diet of the animal that chews
	 */
	public Chew(String name, Point p, double w, IDiet d) {
		super(name, p, w, d);
		MessageUtility.logConstractor("Chew", this.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see animals.Animal#makeSound
	 */
	@Override
	public void makeSound() {
		this.chew();
	}

	/**
	 * A method that makes an animal chew
	 */
	public abstract void chew();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Chew] : " + this.getName();
	}
}

