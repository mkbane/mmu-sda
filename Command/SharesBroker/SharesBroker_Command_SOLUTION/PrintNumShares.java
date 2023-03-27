/*
 * CONCRETE COMMAND
 *
 */
public class PrintNumShares implements SharesOrder {
    private Shares shares;

    public PrintNumShares(Shares s) {
	this.shares = s;
    }
    public void execute() {
	shares.printNumShares();
    }
}
