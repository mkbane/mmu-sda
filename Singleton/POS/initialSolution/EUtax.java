public class EUtax extends CalcTax {
    /*
     * subclass to handle EU tax (33%) tax rate
     */


    public EUtax() {
	taxRate = 0.33f;
	System.out.println("New CalcTax for applying " + (taxRate*100) + "% tax rates in EU");
    }

    public float getTaxAmount(float total) {
	return taxRate * total;
    }
}
