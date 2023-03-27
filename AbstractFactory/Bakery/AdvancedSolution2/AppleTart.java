public class AppleTart extends Tart {
    public AppleTart() {
	System.out.println("Creating an Apple Tart");
    }

    // use relevant fruit factory
    public void addFruit() {
	System.out.println("...add layer of apple fruit");
    }

    // bake all tarts similarly
    public void bake() {
	System.out.println("...baking at 220C");
    }
}
