package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A class that defines herbivore.
 * 
 * @version April 2022
 * @author Demi Netzer
 */
public class Herbivore implements IDiet {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see diet.IDiet#canEat
	 */
	@Override
	public boolean canEat(EFoodType food) {
		if (food == EFoodType.VEGETABLE)
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see diet.IDiet#eat
	 */
	@Override
	public double eat(Animal animal, IEdible food) {
		if (this.canEat(food.getFoodtype())) {
			return animal.getWeight()*0.07;
		}
		return 0;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Herbivore]";
	}

}
