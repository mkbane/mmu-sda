/*
 * AppController: 
 * Welcome to the Bakery!
 */

import java.util.ArrayList;

public class AppController {
    public static void main(String args[]) {
	System.out.println("Booting AppController...");

	// fruity familes are (Apple, Banana, Cherry)
	// products per family are Pie, Tart, Pastry

	// let's make some random selections
	Pie pie1 = new ApplePie();
	Pie pie2 = new BananaPie();
	Tart tart = new AppleTart();
	Pastry pastry = new BananaPastry();

	/*
	 * we also want to bake-on-demand i.e. determine Fruit at run time and then bake the relevant Pie
	 * the below (and the given Pie constructors & inheritence) is a really ugly solution
	 * How would you improve this?
	 */
	java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.print("Enter fruit (Apple, Banana, Cherry, ...): ");
	String fruit = keyboard.next();
	
	Pie pie3 = new Pie(fruit);
    }
}
