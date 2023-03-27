public class CherryFruitFactory extends FruitFactory {
    public Pie createPie() {
	return new CherryPie();
    }
    public Tart createTart() {
	return new CherryTart();
    }
    public Pastry createPastry() {
	return new CherryPastry();
    }
}
