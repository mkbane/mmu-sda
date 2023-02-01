/* this is ADAPTER where old Line can be called but implements new StraightLine */

public class Line {
    private StraightLine myLine;
    public Line() {
        myLine = new StraightLine();
    }
    public void draw(double x1, double y1, double x2, double y2) {
        double r1 = java.lang.Math.sqrt(x1*x1 + y1*y1);
        double r2 = java.lang.Math.sqrt(x2*x2 + y2*y2);
        double theta1 = Math.atan(y1/x1);
        double theta2 = Math.atan(y2/x2);
        myLine.drawIt(r1,theta1,r2,theta2);
    }
}
