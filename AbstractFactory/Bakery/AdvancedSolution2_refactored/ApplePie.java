public class ApplePie extends Pie {
    public ApplePie() {
	System.out.println("Constructing an Apple Pie");
    }

    // use relevant fruit factory
    public void addFruit() {
	System.out.println("...add apple fruit");
    }

    // bake all pies similarly
    public void bake() {
	System.out.println("...baking at 200C");
    }

}
