/*
 * CONCRETE COMMAND
 *
 */
public class BuyShares implements SharesOrder {
    private Shares shares;
    private int num;
    public BuyShares(Shares s, int num) {
	this.shares = s;
	this.num = num;
    }
    public void execute() {
	shares.buyShares(num);
    }
}
