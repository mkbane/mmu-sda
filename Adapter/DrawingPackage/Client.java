public class Client {
    
    public static void main(String[] args) {
        System.out.print("hello world\n");
        // create and draw a rectangle by drawing four lines
	int x1=10, y1=100;  // top left
	int x2=100, y2=100; // top right
	int x3=100, y3=10;  // lower right
	int x4=10, y4=10;   // lower left

        Line upperLine = new Line();
	Line rightLine = new Line();
	Line lowerLine = new Line();
	Line leftLine = new Line();


	upperLine.draw(x1,y1, x2,y2);
	rightLine.draw(x2,y2, x3,y3);
	lowerLine.draw(x3,y3, x4,y4);
	leftLine.draw(x4,y4, x1,y1);
			
        return;
    }


}
