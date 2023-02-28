public class FlatOfStraw extends Flat {

    private Straw materials;

    public FlatOfStraw() {
	super("straw");
	materials = new Straw();
    }

    public void build() {
	materials.buildWithMaterials();
    }
    
}
