package pg;

public class Point {
    
    /*
     * The x- and y-coordinate of the point. Not immutable to allow users
     * to change these coordinates with the setX() and setY() methods should
     * they need the functionality to move the point in their program.
     */
    private int x;
    private int y;
    
    /*
     * Creates an instance of Point with the x- and y-coordinates set at 0 
     */
    public Point() {
        this(0, 0);
    }
    
    /*
     * Creates an instance of Point at the given x- and y-coordinates
     */
    public Point(int x, int y) {
        setX(x);
        setY(y);
    }
    
    /*
     * Sets the x-coordinate of the point.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /*
     * Sets the y-coordinate of the point.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /*
     * Gets the x-coordinate of the point.
     */
    public int getX() {
        return x;
    }
    
    /*
     * Gets the y-coordinate of the point.
     */
    public int getY() {
        return y;
    }
    
    public static void main(String[] args) {
        
        Point point1 = new Point(2, 3);
        Point point2 = new Point(-4, 0);
        Point point3 = new Point();
        
        System.out.printf("(%d, %d)\n", point1.getX(), point1.getY());
        System.out.printf("(%d, %d)\n", point2.getX(), point2.getY());
    }
}