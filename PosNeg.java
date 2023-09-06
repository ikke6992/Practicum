public class PosNeg {

    public static boolean posNeg(int firstNum, int secondNum, boolean negative) {
        if (negative) {
            return firstNum < 0 && secondNum < 0;
        } else {
            return (firstNum < 0 && secondNum >= 0) ||
                (firstNum >= 0 && secondNum < 0);
        }
    }

    public static void main(String[] args) {
        System.out.println(posNeg(1, -1, false));
        System.out.println(posNeg(-1, 1, false));
        System.out.println(posNeg(-4, -5, true));
        System.out.println(posNeg(1, 2, false));
        System.out.println(posNeg(-1, -1, false));
        System.out.println(posNeg(4, -5, true));
    }
}