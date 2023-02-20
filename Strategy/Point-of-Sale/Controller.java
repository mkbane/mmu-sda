public class Controller {
    public static void main(String[] args) {
	System.out.println("Controller boots...");

	// create a new SaleOrder
	SaleOrder sale1 = new SaleOrder();

	// add arbritary item of value 'cost'  to our SaleOrder item
	float cost=80.00f;
	sale1.addItem(cost);
	// add another item
	sale1.addItem(20.00f);

	// find UK tax for total sale
	float UKtax = sale1.calcTax();

	System.out.println("Total cost:" +   sale1.calcTotalCost() + " of which UK tax=" + UKtax);
    }
}
