public class Kiosk {
    /* 
     * Kiosk creates one or more Burgers via BurgerMaker
     * Burger has a breadStyle (PlainRoll, GranaryRoll, WhiteBreadSandwich)
     *   and a filling (meat, spicyMeat, fish, veggie, vegan)
     */

    public static void main(String[] args) {
	// make 4 different Burger(breadStyle, filling)
	
	BurgerMaker bm = new BurgerMaker();
	Burger b1 = bm.createBurger("PlainRoll", "meat");
	Burger b2 = bm.createBurger("PlainRoll", "spicyMeat");
	Burger b3 = bm.createBurger("GranaryRoll", "veggie");
	Burger b4 = bm.createBurger("WhiteBreadSandwich", "vegan"); 

	// check what's cookin
	System.out.println("Order ready:\n" + b1.getName() + "\n" + b2.getName() + "\n" + b3.getName() + "\n" + b4.getName() + "\n");
	
	System.out.println("Normally terminating...");
    }
}
