public class AppleFruitFactory extends FruitFactory {
    public Pie createPie() {
	Pie pie = new ApplePie();
	pie.cook();
	return pie;
    }
    public Tart createTart() {
	Tart tart = new AppleTart();
	tart.cook();
	return tart;
    }
    public Pastry createPastry() {
	Pastry pastry = new ApplePastry();
	pastry.cook();
	return pastry;
    }
}
