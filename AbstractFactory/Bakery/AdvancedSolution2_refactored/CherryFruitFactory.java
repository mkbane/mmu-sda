public class CherryFruitFactory extends FruitFactory {
    public Pie createPie() {
	Pie pie = new CherryPie();
	pie.cook();
	return pie;
    }
    public Tart createTart() {
	Tart tart = new CherryTart();
	tart.cook();
	return tart;
    }
    public Pastry createPastry() {
	// unique recipe
	Pastry pastry = new CherryPastry();
	pastry.bake();
	pastry.addFruit();
	return pastry;
    }
}
