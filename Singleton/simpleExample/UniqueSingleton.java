public class UniqueSingleton {
    // global variable 'instance' of type of the class 'UniqueSingleton'
    private static UniqueSingleton instance;

    
    private UniqueSingleton() {
	// am I unique instantiation?
	System.out.printf("Hi from instantiation of UniqueSINGLETON\n");
    }

    public static UniqueSingleton getInstance() {
	if (instance == null) {
	    // there is no current instance so set one up
	    instance = new UniqueSingleton();
	}
	else {
	    // we can return the current instance
	    System.out.println("using current instance!");
	}

	return instance;
    } // getInstance
}
