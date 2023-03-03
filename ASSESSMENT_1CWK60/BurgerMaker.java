public class BurgerMaker {

    public Burger createBurger(String breadStyle, String filling) {
	Burger burger = null;
	System.out.println("Order received for " + breadStyle + " with " + filling);

	if (breadStyle == "PlainRoll") {
	    if (filling == "meat") burger = new plainRoll_meat_burger();
	    if (filling == "spicyMeat") burger = new plainRoll_spicyMeat_burger();
	    if (filling == "veggie") burger = new plainRoll_veggie_burger();
	    if (filling == "vegan") burger = new plainRoll_vegan_burger();
	    if (filling == "fish") burger = new plainRoll_fish_burger();
	}

	if (breadStyle == "GranaryRoll") {
	    if (filling == "meat") burger = new granaryRoll_meat_burger();
	    if (filling == "spicyMeat") burger = new granaryRoll_spicyMeat_burger();
	    if (filling == "veggie") burger = new granaryRoll_veggie_burger();
	    if (filling == "vegan") burger = new granaryRoll_vegan_burger();
	    if (filling == "fish") burger = new granaryRoll_fish_burger();
	}

	if (breadStyle == "WhiteBreadSandwich") {
	    if (filling == "meat") burger = new whiteBreadSandwich_meat_burger();
	    if (filling == "spicyMeat") burger = new whiteBreadSandwich_spicyMeat_burger();
	    if (filling == "veggie") burger = new whiteBreadSandwich_veggie_burger();
	    if (filling == "vegan") burger = new whiteBreadSandwich_vegan_burger();
	    if (filling == "fish") burger = new whiteBreadSandwich_fish_burger();
	}

	return burger;
    }
    
}
