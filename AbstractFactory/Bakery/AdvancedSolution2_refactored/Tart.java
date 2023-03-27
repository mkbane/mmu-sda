public abstract class Tart {
    public abstract void addFruit();
    public abstract void bake();
    public void cook() {
	addFruit();
	bake();
    }
}
