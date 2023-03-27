public class BananaFruitFactory extends FruitFactory {
    public Pie createPie() {
	Pie pie = new BananaPie();
	pie.cook();
	return pie;
    }
    public Tart createTart() {
	Tart tart = new BananaTart();
	tart.cook();
	return tart;
    }
    public Pastry createPastry() {
	Pastry pastry = new BananaPastry();
	pastry.cook();
	return pastry;
    }
}
