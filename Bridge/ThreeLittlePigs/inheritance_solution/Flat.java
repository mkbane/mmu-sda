public class Flat extends Accommodation {
    public Flat(String typeOfFlat) {
	super("flat (1 layer Accommodation) of " + typeOfFlat);
    }

    public void build() {
	// this could be made abstract if all subclasses have own build()
	// a flat has ONE layer
    }
}
