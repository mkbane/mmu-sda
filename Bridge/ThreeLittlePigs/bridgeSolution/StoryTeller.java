public class StoryTeller {
    public static void main(String[] args) {
	System.out.println("Once upon a time...");
	// House can be made of: straw, sticks, brick
	Accommodation house1 = new House();
	house1.setMaterialType(new Bricks());
	house1.build();

	/*
	house2.build();
	house3.build();
	*/
	// Flat can be made of: straw, sticks, brick
	Accommodation flat1 = new Flat();
	flat1.setMaterialType(new Bricks());
	flat1.build();
	/*
	FlatOfSticks flat2 = new FlatOfSticks();
	FlatOfBricks flat3 = new FlatOfBricks();
	// build each flat
	flat1.build();
	flat2.build();
	flat3.build();
	*/


	// to add: how to use polymorphism for this example!
    }
}
	    
