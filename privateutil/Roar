package privateutil;

import animals.Animal;
import diet.IDiet;
import mobility.Point;
import utilities.MessageUtility;

/**
 * A class that defines animals that roars.
 * @version April 2022
 * @author Demi Netzer
 */
public abstract class Roar extends Animal{

	/**
	 * Constructor 
	 * @param name
	 * 			- name of the animal that roars
	 * @param p
	 * 			- location of the animal that roars
	 * @param w
	 * 			- weight of the animal that roars
	 * @param d
	 * 			- diet of the animal that roars
	 */
	public Roar(String name, Point p, double w, IDiet d) {
		super(name, p, w, d);
		MessageUtility.logConstractor("Roar", this.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see animals.Animal#makeSound
	 */
	@Override
	public void makeSound() {
		this.roar();

	}

	/**
	 * A method that makes an animal roar
	 */
	public abstract void roar();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Roar] : " + this.getName();
	}

}
