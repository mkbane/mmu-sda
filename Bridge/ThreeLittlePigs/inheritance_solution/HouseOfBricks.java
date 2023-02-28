public class HouseOfBricks extends House {

    private Bricks materials;

    public HouseOfBricks() {
	super("bricks");
	materials = new Bricks();
    }

    public void build() {
	// a house has TWO layers
	materials.buildWithMaterials();
	materials.buildWithMaterials();	
    }

}
