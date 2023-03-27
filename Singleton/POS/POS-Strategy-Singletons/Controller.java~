import java.util.Scanner;
public class Controller {
    /*
     *
     * See lab04 (strategy)
     * 
     * This is an expanded version of the Controller from lab04.
     * 
     * Today's scenario: this software runs globally across all our shops in each of USA, UK, EU, Japan
     * To mimic new sales, in many countries, we loop over reading from the commanding line which Tax rules to apply.
     * We then select 3 random values to add to the SaleOrder and then calculate & display the tax proportion.
     *
     * Note that we have amended the constructor of each concrete tax class to output when it creates a new object
     *
     */

    public static void main(String[] args) {
	System.out.println("Controller boots...");
	Scanner keyboard = new Scanner(System.in);
	String country;
	CalcTax taxRules = null;
	boolean myContinue = true;
	SaleOrder saleorder;
	float taxAmount;
	
	do {
	    System.out.print("Enter country of sales [UK, USA, EU, Japan] (other entry to terminate): ");
	    country = keyboard.next();

	    // initiate relevant concrete implementation of calcTax class
	    switch (country) {
	    case "UK":
		taxRules = new UKtax(); 
		break;
	    case "USA":
		taxRules = new USAtax();
		break;
	    case "EU":
		taxRules = new EUtax();
		break;
	    case "Japan":
		taxRules = new Japantax();
		break;
	    default:
		myContinue = false;
	    }
	    if (myContinue) {
		saleorder = new SaleOrder();

		// add 3 arbritary items to saleorder of between 50 and 100 units (e.g. GBP, USD, Euro, Yen)
		// (we arbitrarily only have prices rounded to nearest GBP, USD etc)
		saleorder.addItem(50.0f + (int) ((float) Math.random()*50.0f));
		saleorder.addItem(50.0f + (int) ((float) Math.random()*50.0f));
		saleorder.addItem(50.0f + (int) ((float) Math.random()*50.0f));

		// find tax part for total sale
		taxAmount = saleorder.calcTax(taxRules);

		System.out.println("Total cost:" +   saleorder.calcTotalCost() + " of which tax=" + taxAmount);
	    } // if
	} while (myContinue);

	System.out.println("System closing");
	
    }
}
