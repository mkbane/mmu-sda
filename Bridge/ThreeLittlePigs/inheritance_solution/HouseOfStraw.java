public class HouseOfStraw extends House {

    private Straw materials;

    public HouseOfStraw() {
	super("straw");
	materials = new Straw();
    }

    public void build() {
	// a house has TWO layers
	materials.buildWithMaterials();
	materials.buildWithMaterials();
    }
    
}
