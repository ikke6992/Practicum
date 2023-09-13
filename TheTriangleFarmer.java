import java.util.Scanner;

public class TheTriangleFarmer {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What's the length of the triangle?");
        double length = scanner.nextDouble();
        
        System.out.println("What's the height of the triangle?");
        double height = scanner.nextDouble();
        
        double area = (length * height)/2;
        System.out.println("The area of the triangle is: " + area);
    }
}