public class Flat extends Accommodation {
    public Flat() {
	super("flat (1 layer Accommodation)");
    }

    public void build() {
	// a flat has ONE layer
	materialType.buildWithMaterials();
    }
}
