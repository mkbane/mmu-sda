public class EUtax extends CalcTax {
    /*
     * subclass to handle EU tax (33%) tax rate
     */

    public float getTaxAmount(float total) {
	return 0.33f * total;
    }
}
