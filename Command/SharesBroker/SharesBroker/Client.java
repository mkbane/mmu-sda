public class Client {
    public static void main(String[] args) {
	Shares shares = new Shares();

	Broker broker = new Broker(shares);

	// implement all orders as they happen (not ideal...)
	broker.buyShares(10);
	broker.sellShares(5);
	broker.buyShares(25);

	// ensure print out balance
	broker.printNumShares();

	// close the broker (and save some fees)
	broker = null;
	
    }
}
			 

