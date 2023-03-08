public class ApplePastry extends Pastry {
    public ApplePastry() {
	System.out.println("Creating an Apple Pastry");
    }

    // use relevant fruit
    public void addFruit() {
	System.out.println("...squeeze apple mush on top");
    }

    // bake all pastries similarly
    public void bake() {
	System.out.println("...baking slowly at 180C");
    }
}
