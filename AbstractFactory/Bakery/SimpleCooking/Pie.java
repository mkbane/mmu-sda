public class Pie {
    private Pie pie;
    public Pie() {
    }

    public Pie(String fruit) {
	System.out.println("Pretty Pie time!");
	switch(fruit) {
	case "Apple":
	    pie = new ApplePie();
	    break;
	case "Banana":
	    pie = new BananaPie();
	    break;
	}
	// but we then need a method to return the actual pie?
    }
}
