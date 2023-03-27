public class HomeMovie {
    public static void main (String[] args) {
	/*
	 * we wish to make coffee, select movie on BluRay, turn on amplifier,
	 * display screen and then watch the movie
	 */

	// set up each item
	CoffeeMaker cm = new CoffeeMaker();
	BlurayCollection movies = new BlurayCollection();
	Amplifier amp  = new Amplifier(); 
	Screen screen = new Screen();
	Projector proj = new Projector();
	Player player = new Player();

	// use Facade to initiate the HomeMovie
	HomeMovieFacade hmf = new HomeMovieFacade(cm, movies, amp, screen, proj,
						  player);
	

	// boot our Home Movie set-up
	hmf.boot();

	// play specific film
	hmf.watch("Mad Max 2", "Bluray");

	// get some coffee
	hmf.getCoffee("latte");

	// play another film but louder volume
	hmf.setVolume(hmf.getVolume()+2);
	hmf.watch("Mad Max 3", "DVD");

	// shut it all down
	hmf.shutdown();
	

	System.out.println("goodnight!");
	
    }
}
