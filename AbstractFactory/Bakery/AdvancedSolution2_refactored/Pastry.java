public abstract class Pastry {
    public abstract void addFruit();
    public abstract void bake();
    public void cook() {
	addFruit();
	bake();
    }
}
