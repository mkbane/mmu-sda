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
        for (int i=0; i<NUM; i++) {
            UniqueSingleton US = UniqueSingleton.getInstance();
        }
    }
}
