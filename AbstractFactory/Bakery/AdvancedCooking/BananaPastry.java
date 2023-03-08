public class BananaPastry extends Pastry {
    public BananaPastry() {
	System.out.println("Creating an Banana Pastry");
    }

    // use relevant fruit
    public void addFruit() {
	System.out.println("...slice bananas on top");
    }

    // bake all pastries similarly
    public void bake() {
	System.out.println("...baking slowly at 180C");
    }
}
