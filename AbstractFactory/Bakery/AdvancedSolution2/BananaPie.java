public class BananaPie extends Pie {
    public BananaPie() {
	System.out.println("Constructing an Banana Pie");
    }

    // use relevant fruit factory
    public void addFruit() {
	System.out.println("...add mashed up banana fruit");
    }

    // bake all pies similarly
    public void bake() {
	System.out.println("...baking at 200C");
    }

}
