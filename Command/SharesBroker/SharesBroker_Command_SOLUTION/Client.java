public class Client {
    public static void main(String[] args) {
	Shares shares = new Shares();

	// set up COMMANDS to buy 10, then sell 5, then buy 25
	BuyShares buySharesOrder1  = new BuyShares(shares,10);
	SellShares sellSharesOrder1 = new SellShares(shares,5);
	BuyShares buySharesOrder2  = new BuyShares(shares,25);

	// take all orders
	Broker broker = new Broker();
	broker.takeOrder(buySharesOrder1);
	broker.takeOrder(sellSharesOrder1);
	broker.takeOrder(buySharesOrder2);

	// ensure print out balance
	broker.takeOrder(new PrintNumShares(shares));
	
	// place orders
	broker.placeOrders();
    }
}
			 

