public class House extends Accommodation {
    public House() {
	super("house (TWO layer Accommodation)");
    }

    public void build() {
	// a house has TWO layers
	materialType.buildWithMaterials();
	materialType.buildWithMaterials();
    }
}
