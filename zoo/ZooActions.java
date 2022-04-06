package zoo;
import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Scanner;
import java.util.Random;

/**
 * Class of generic functions
 * @version April 2022
 * @author Demi Netzer
 */
public class ZooActions {
	
	/**
	 * A method that returns true if the animal can
	 * eat the food
	 * @param animal
	 * @param food
	 * @return if the animal can eat the food: true
			   otherwise: false
	 */
	public static boolean eat(Object animal, IEdible food) {
		boolean flag = false;
		if (animal instanceof Lion) {
			flag = ((Lion) animal).eat(food);
			MessageUtility.logBooleanFunction(((Lion) animal).getName(), "eat", food, flag);
			return flag;
		}
		if (animal instanceof Bear) {
			flag = ((Bear) animal).eat(food);
			MessageUtility.logBooleanFunction(((Bear) animal).getName(), "eat", food, flag);
			return flag;
		}
		if (animal instanceof Elephant) {
			flag = ((Elephant) animal).eat(food);
			MessageUtility.logBooleanFunction(((Elephant) animal).getName(), "eat", food, flag);
			return flag;
		}
		if (animal instanceof Giraffe) {
			flag = ((Giraffe) animal).eat(food);
			MessageUtility.logBooleanFunction(((Giraffe) animal).getName(), "eat", food, flag);
			return flag;
		}
		if (animal instanceof Turtle) {
			flag = ((Turtle) animal).eat(food);
			MessageUtility.logBooleanFunction(((Turtle) animal).getName(), "eat", food, flag);
			return flag;
		}
		return false;
	}
	
	/**
	 * A method that moves the animal to a new location
	 * @param animal
	 * @param point
	 * 			- A point that represents a new location
	 * @return If the move was made: true,
	 * 	       otherwise: false
	 */
	public static boolean move(Object animal, Point point) {
		if (!Point.cheackBounderies(point) && animal instanceof Animal) {
			MessageUtility.logBooleanFunction(((Animal) animal).getName(), "move", point , false);			
			return false;
		}
		if (animal instanceof Lion) { 
			((Lion) animal).move(point);
			MessageUtility.logBooleanFunction(((Lion) animal).getName(), "move", point , true);
			return true;
		}
		if (animal instanceof Bear) { 
			((Bear) animal).move(point);
			MessageUtility.logBooleanFunction(((Bear) animal).getName(), "move", point , true);
			return true;
		}
		if (animal instanceof Elephant) { 
			((Elephant) animal).move(point);
			MessageUtility.logBooleanFunction(((Elephant) animal).getName(), "move", point , true);
			return true;
		}
		if (animal instanceof Giraffe) { 
			((Giraffe) animal).move(point);
			MessageUtility.logBooleanFunction(((Giraffe) animal).getName(), "move", point , true);
			return true;
		}
		if (animal instanceof Turtle) { 
			((Turtle) animal).move(point);
			MessageUtility.logBooleanFunction(((Turtle) animal).getName(), "move", point , true);
			return true;
		}
		return false;	
	}
	
	
	/**
	 * main method
	 * @param arg
	 */
	public static void main(String[] arg) {
		
		int scarCount, age, size, i, x, y, food, predator;
		double neckLength, trunkLength, weight;
		String furColor;
		Point p;
		
		System.out.println("********************************************");
		System.out.println("                 Initilize                  ");
		System.out.println("********************************************");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		size = sc.nextInt();		
		while (size < 3) {
			System.out.println("The minimum array size is 3, try again :");
			size = sc.nextInt();	
		}
		Animal[] animals = new Animal[size]; 
		

		for (i = 0 ; i < size ; ++i) {
			
			System.out.println("\nWhat animal do you want ? ");
			String type = sc.next();
			System.out.println("Enter name : ");
			String name = sc.next();
			System.out.println("Enter location : (x) = ");
			x = sc.nextInt();
			System.out.println("(y) = ");
			y = sc.nextInt();
			p = new Point(x, y);
			System.out.println("Enter weight : ");
			weight = sc.nextInt();
			
			if (type.equals("Lion")){
				System.out.println("Enter number of scars : ");
				scarCount = sc.nextInt();
				animals[i] = new Lion(name, p, weight, scarCount);
			}
			
			
			if (type.equals("Bear")){
				System.out.println("Enter fur color : ");
				furColor = sc.next();
				animals[i] = new Bear(name, p, weight, furColor);
			}
			
			if (type.equals("Elephant")){
				System.out.println("Enter trunk length : ");
				trunkLength = sc.nextDouble();
				animals[i] = new Elephant(name, p, weight, trunkLength);
			}
			
			if (type.equals("Giraffe")){
				System.out.println("Enter neck length : ");
				neckLength = sc.nextDouble();
				animals[i] = new Giraffe(name, p, weight, neckLength);
			}
			
			if (type.equals("Turtle")){
				System.out.println("Enter age : ");
				age = sc.nextInt();
				animals[i] = new Turtle(name, p, weight, age);
			}	
			System.out.println("_____________________________________________");
		}
		
		System.out.println("********************************************");
		System.out.println("                    Move                    ");
		System.out.println("********************************************");

		
		for(i = 0 ; i < size; ++i ) {
			if (animals[i] instanceof Animal) {
				String s = String.format("\nEnter new location to : %s ", animals[i].getName());
				System.out.println(s);
				System.out.println("enter x : ");
				x = sc.nextInt();
				System.out.println("enter y : ");
				y = sc.nextInt();
				p = new Point(x,y);
				ZooActions.move(animals[i], p);
				System.out.println("_____________________________________________");
			}
		}

		
		System.out.println("********************************************");
		System.out.println("                    Feed                    ");
		System.out.println("********************************************");

		
		for (i =0; i < (size/2) ; ++i ) {
			Random random = new Random();
			do {
				predator = random.nextInt(size);
			} while(!(animals[predator] instanceof Animal));	
			do {
				food = random.nextInt(size);	
			} while(!(animals[food] instanceof Animal));
			if (ZooActions.eat(animals[predator], animals[food]))
				animals[food] = null;
			System.out.println("_____________________________________________");
		}
		sc.close();
			
	}
	
	
	
}

