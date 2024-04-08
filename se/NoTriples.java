package se;

public class NoTriples {

    public static boolean noTriples(int...numbers) {

        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] == numbers[i + 1] && numbers[i] == numbers[i + 2]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(noTriples(1, 1, 2, 2, 1));
        System.out.println(noTriples(1, 1, 2, 2, 2, 1));
        System.out.println(noTriples(1, 1, 1, 2, 2, 2, 1));
    }
}