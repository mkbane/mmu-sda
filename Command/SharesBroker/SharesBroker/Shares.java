/*
 * REQUEST class
 *
 * Shares available in "Gold"
 * Initially we hold 10 shares
 *
 * TO DO: expand to use enum: "Gold", "Silver", "Bronze"
 */
public class Shares {
    private String name = "Gold";
    private int numShares = 10;

    public Shares() {
	System.out.println("A new account is given " + numShares + " of " + name);
    }
    
    public void buyShares(int num) {
	System.out.println("Buying " + num + " shares");
	numShares += num;
    }
    
    public void sellShares(int num) {
	System.out.println("Selling " + num + " shares");
	numShares -= num;
    }

    public void printNumShares() {
	System.out.println("Your account has " + numShares + " of " + name);
    }
}
    
