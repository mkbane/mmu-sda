public class AppleFruitFactory extends FruitFactory {
    public Pie createPie() {
	return new ApplePie();
    }
    public Tart createTart() {
	return new AppleTart();
    }
    public Pastry createPastry() {
	return new ApplePastry();
    }
}
