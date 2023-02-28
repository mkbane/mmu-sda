public class HouseOfSticks extends House {

    private Sticks materials;

    public HouseOfSticks() {
	super("sticks");
	materials = new Sticks();
    }

    public void build() {
	// a house has TWO layers
	materials.buildWithMaterials();
	materials.buildWithMaterials();
    }
    
}
