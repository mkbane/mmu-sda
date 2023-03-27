/*
 * this is the required abstract class for Strategy DP
 */
public abstract class CalcTax {
    float taxRate;
    public CalcTax() {}

    abstract public float getTaxAmount(float value);
}
