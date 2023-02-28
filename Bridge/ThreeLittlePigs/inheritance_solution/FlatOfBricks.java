public class FlatOfBricks extends Flat {

    private Bricks materials;

    public FlatOfBricks() {
	super("bricks");
	materials = new Bricks();
    }

    public void build() {
	materials.buildWithMaterials();
    }

}
