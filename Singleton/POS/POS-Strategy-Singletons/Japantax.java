public class Japantax extends CalcTax {
    /*
     * subclass to handle Japan tax (2.25%) tax rate
     */

    private static CalcTax instance = null;
    
    private Japantax() {
	taxRate = 0.025f;
	System.out.println("New CalcTax for applying " + (taxRate*100) + "% tax rates in Japan");
    }


    public static CalcTax getInstance() {
	if (instance == null) {
	    instance = new Japantax();
	}
	return instance;
    }
	     
    
    public float getTaxAmount(float total) {
	return 0.0225f * total;
    }
}
