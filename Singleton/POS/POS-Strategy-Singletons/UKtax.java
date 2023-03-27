public class UKtax extends CalcTax {
    /*
     * subclass to handle UK tax (20%) tax rate
     */

    public UKtax() {
	taxRate = 0.2f;
	System.out.println("New CalcTax for applying " + (taxRate*100) + "% tax rates in UK");
    }

    public float getTaxAmount(float total) {
	return taxRate * total;
    }
}
