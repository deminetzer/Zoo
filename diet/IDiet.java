package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * An interface that describes the functionality of eating.
 * 
 * @version April 2022
 * @author Demi Netzer
 */
public interface IDiet {
	
	/**
	 * A method that returns "true" if the parameter 
	 * is food that the object can eat.
	 * 
	 * @param food
	 * 				- type of food
	 * @return if the object can eat the food : true,
	 * 		   otherwise : false.
	 */
	public boolean canEat(EFoodType food);
	
	/**
	 * A method that return the weight that an animal will
	 * gain if it can eat the food obtained as a parameter.
	 * 
	 * @param animal
	 * 				- An animal that should eat the food.
	 * @param food
	 * 				- Food for the animal.
	 * @return The weight that the animal will gain.
	 */
	public double eat(Animal animal, IEdible food);
}
