public class CherryPastry extends Pastry {
    public CherryPastry() {
	System.out.println("Creating tasty Cherry Pastry");
    }

    // use relevant fruit factory
    public void addFruit() {
	System.out.println("...squeeze cherry paste on top");
    }

    // bake all pastries similarly
    public void bake() {
	System.out.println("...baking slowly at 180C");
    }
}
