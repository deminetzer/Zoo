package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

/**
 * A class that defines an Animal.
 * @version April 2022
 * @author Demi Netzer
 */
public abstract class Animal extends Mobile implements IEdible {
	
	private String name;
	private double weight;
	private IDiet diet;
	
	/**
	 * Constructor for Animal object
	 * @param name
	 * 			- name of animal
	 * @param p
	 * 			- location of animal
	 */
	public Animal(String name ,Point p) {
		super(p);
		this.name = name;
		MessageUtility.logConstractor("Animal", this.getName());
	}
	
	/**
	 * Constructor for Animal object
	 * @param name
	 * 			- name of animal
	 * @param p
	 * 			- location of animal
	 * @param w
	 * 			- weight of animal
	 * @param d
	 * 			- diet of animal
	 */
	public Animal(String name ,Point p, double w, IDiet d) {
		super(p);
		MessageUtility.logConstractor("Animal", name);
		this.name = name;
		this.setWeight(w);
		this.setDiet(d);
	}
	
	
	/**
	 * A method that returns the name of the animal
	 * @return name of animal
	 */
	public String getName() {
		MessageUtility.logGetter(this.name, "getName", this.name);
		return this.name;
	}
	
	/**
	 * A method that defines a new name for an animal
	 * @param name
	 * 			- new name of the animal 
	 * @return true : If the setting was performed
	 */
	public boolean setName(String name) {
		MessageUtility.logSetter(this.getName(), "setName", name, true);
		this.name = name;
		return true;
	}
	
	/**
	 * A method that returns the weight of the animal
	 * @return weight of animal
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.name, "getWeight", String.format("%.2f", this.weight));
		return this.weight;
	}
	
	/**
	 * A method that defines a new weight for an animal
	 * @param w
	 * 			- new weight of the animal 
	 * @return If the setting was performed : true,
	 * 		   Otherwise : false.
	 */
	public boolean setWeight(double w) {
		if (w < 0) {
			MessageUtility.logSetter(this.getName(), "setWeight", String.format("%.2f", w), false);
			return false; }
		this.weight = w;
		MessageUtility.logSetter(this.getName(), "setWeight", String.format("%.2f", w), true);
		return true;
	}
	
	/**
	 * A method that returns the diet of the animal
	 * @return diet of animal
	 */
	public IDiet getDiet() {
		MessageUtility.logGetter(this.name, "getDiet", this.diet);
		return this.diet;
	}
	
	/**
	 * A method that defines a new diet for an animal
	 * @param d
	 * 			- new diet of the animal 
	 * @return true : If the setting was performed
	 */
	public boolean setDiet(IDiet d) {
		MessageUtility.logSetter(this.getName(), "setDiet", d, true);
		this.diet = d;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IEdible#getFoodtype
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
		return EFoodType.MEAT;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.Mobile#move
	 */
	public double move(Point p) {
		double dis = super.move(p);
		if (dis == 0)
			return 0;
		
		this.setWeight(this.getWeight()
		- (dis*this.getWeight()*0.00025));
		
		return dis;
	}
	
	/**
	 * A method that gets food and returns 
	 * true if the animal ate the food
	 * @param diet 
	 * 			  -  food for the animal
	 * @return If the animal eats this type of food : true,
	 * 		   otherwise: false
	 */
	public boolean eat(IEdible diet) {
		double additional_w = this.getDiet().eat(this, diet);
		if (additional_w == 0) {
			return false;
		}
		this.setWeight(getWeight() + additional_w);
		this.makeSound();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Animal] : " + this.getName();
	}

	/**
	 * A method that activates the animal's voice.
	 */
	public abstract void makeSound();

}
