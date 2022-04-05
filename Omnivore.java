package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A class that defines omnivore.
 * 
 * @version April 2022
 * @author Demi Netzer
 */
public class Omnivore implements IDiet {
	private final Carnivore c = new Carnivore();
	private final Herbivore h = new Herbivore();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see diet.IDiet#canEat
	 */
	@Override
	public boolean canEat(EFoodType food) {
		return c.canEat(food) || h.canEat(food) ;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see diet.IDiet#eat
	 */
	@Override
	public double eat(Animal animal, IEdible food) {

		return c.eat(animal, food) + h.eat(animal, food);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Omnivore]";
	}
}
