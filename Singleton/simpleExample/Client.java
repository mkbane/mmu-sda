public class Client {
    public static void main(String[] args) {
        int NUM = 10;
        System.out.printf("Client will call 'Unique' %d times...\n", NUM);
        for (int i=0; i<NUM; i++) {
            Unique U = new Unique();
        }

        /* this will not compile since private constructor
        System.out.printf("Attempt to call 'UniqueSingleton' constructor\n");
        UniqueSingleton US = new UniqueSingleton();
        */

        System.out.printf("Client will call 'UniqueSingleton' %d times...\n", NUM);

	/*
	 * constructor for US is private so we cannot use
	 *	    UniqueSingleton US = new UniqueSingleton();
	 * thus we call US statically, which will require
	 * getInstance() to be static within US
	 * (we use a method without instantianting an object first)
	 *
	 */

	for (int i=0; i<NUM; i++) {
            UniqueSingleton US = UniqueSingleton.getInstance();
        }
    }
}
