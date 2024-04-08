package se;

public class Front9 {

    public static boolean front9(int...numbers) {

        for (int i = 0; i < Math.min(numbers.length, 4); i++) {
            if (numbers[i] == 9) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(front9(1, 2, 3));
        System.out.println(front9(1, 2, 9, 3, 4));
        System.out.println(front9(1, 2, 3, 4, 9));
        System.out.println(front9(1, 2, 3, 4, 5));
        System.out.println(front9(1, 2, 9));
    }
}