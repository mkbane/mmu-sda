public class House extends Accommodation {
    public House(String typeOfHouse) {
	super("house (TWO layer Accommodation) of " + typeOfHouse);
    }

    public void build() {
	// this could be made abstract if all subclasses have own build()
	// a house has TWO layers
    }
}
