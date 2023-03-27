public class USAtax extends CalcTax {
    /*
     * subclass to handle USA tax (15%) tax rate
     */

    public USAtax() {
	taxRate = 0.15f;
	System.out.println("New CalcTax for applying " + (taxRate*100) + "% tax rates in USA");
    }

    public float getTaxAmount(float total) {
	return taxRate * total;
    }
}
