/*
 * AppController: 
 * will determine which factory (eg depending upon customer's requirements), 
 * and will create this factory at run time 
 */

public class AppController {
    public static void main(String args[]) {
	System.out.println("Booting AppController...");

	// fruit familes are (Apple, Banana, Cherry)
	// products per family are Pie, Tart, Pastry

	FruitFactory fact = null; // Factory, that can then produce products (Pie, Tart, Pastry)
	Pie pie;
	Pastry pastry;
	Tart tart;

	// determine Factory at run time
	java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.print("Enter fruit (Apple, Banana, Cherry, ...): ");
	String fruitType = keyboard.next();
	switch (fruitType) {
	case "Apple":
	    fact = new AppleFruitFactory();
	    break;

	case "Banana":
	    fact = new BananaFruitFactory();
	    break;
	    
	case "Cherry":
	    fact = new CherryFruitFactory();
	    break;

	}

	// build all products with given factory
	pie = fact.createPie();
	pie.addFruit();
	pie.bake();

	pastry = fact.createPastry();
	pastry.addFruit();
	pastry.bake();

	tart = fact.createTart();
	tart.addFruit();
	tart.bake();

    }
}
