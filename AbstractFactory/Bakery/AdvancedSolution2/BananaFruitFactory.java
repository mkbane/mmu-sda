public class BananaFruitFactory extends FruitFactory {
    public Pie createPie() {
	return new BananaPie();
    }
    public Tart createTart() {
	return new BananaTart();
    }
    public Pastry createPastry() {
	return new BananaPastry();
    }
}
