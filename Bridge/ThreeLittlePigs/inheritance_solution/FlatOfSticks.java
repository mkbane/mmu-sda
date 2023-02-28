public class FlatOfSticks extends Flat {

    private Sticks materials;

    public FlatOfSticks() {
	super("sticks");
	materials = new Sticks();
    }

    public void build() {
	materials.buildWithMaterials();
    }
    
}
