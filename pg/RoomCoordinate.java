package pg;

public class RoomCoordinate {

    public record Coordinate(int row, int column) {}
    
    public static boolean adjacent(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.row - c2.row) + Math.abs(c1.column - c2.column) == 1;

    }
    
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(1, 0);
        Coordinate c3 = new Coordinate(0, -1);
        Coordinate c4 = new Coordinate(1, -1);
        
        System.out.println(adjacent(c1, c1));
        System.out.println(adjacent(c1, c2));
        System.out.println(adjacent(c1, c3));
        System.out.println(adjacent(c1, c4));
        System.out.println(adjacent(c2, c3));
        System.out.println(adjacent(c4, c2));
    }
}