public class SaleOrder {
    float total;
    int numItems;
    // set UK tax (i.e. VAT) rate (20%)
    float taxRate=0.2f;
    public SaleOrder() {
	System.out.println("new SaleOrder\nzero everything");
	this.total = 0;
	this.numItems = 0;
    }
    public void addItem(float value) {
	total += value;
	numItems++;
    }
    public float calcTax(CalcTax taxToUse) {
	float tax = taxToUse.getTaxAmount(total);
	return tax;
    }
    public float calcTotalCost() {
	return total;
    }
	
}
