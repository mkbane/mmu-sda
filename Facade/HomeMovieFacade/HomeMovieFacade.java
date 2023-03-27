public class HomeMovieFacade {

    CoffeeMaker cm = new CoffeeMaker();
    BlurayCollection movies = new BlurayCollection();
    Amplifier amp  = new Amplifier(); 
    Screen screen = new Screen();
    Projector proj = new Projector();
    Player player = new Player();


    int vol=3; //defaul vol
    public HomeMovieFacade(CoffeeMaker cm, BlurayCollection movies,
			   Amplifier amp, Screen screen, Projector proj, Player player) {
	this.cm = cm;
	this.movies = movies;
	this.amp = amp;
	this.screen = screen;
	this.proj = proj;
	this.player = player;
    }

    // boot() turns everything on
    public void boot() {
	cm.on();                     // turn on coffee maker
	amp.on();                      // turn on amplifier
	amp.setVolume(vol);           // turn volume to default
	screen.lower();            // lower the screen
	proj.on();                 // turn on projector
	player.on();
    }

    // shutdown() turns everything off
    public void shutdown() {
	player.eject();
	player.off();
	proj.off();
	screen.raise();
	amp.off();
    }


    
    // bunch of usefuls
    public void watch(String m, String playerFormat) {
	// watch the nearest match in given format
	player.setFormat(playerFormat);
	player.play(movies.select(m));
    }

    public void getCoffee(String coffeeType) {
	cm.makeCoffee(coffeeType);
    }


    public int getVolume() {
	return vol;
    }

    public void setVolume(int v) {
	this.vol = v;
	amp.setVolume(this.vol);
    }
	    
}
