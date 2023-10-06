package se;

public class Max1020 {
    
    public static int max1020(int firstNum, int secondNum) {
        if(firstNum >= 10 && firstNum < 20) {
            if (secondNum >= 10 && secondNum <= 20) {
                return Math.max(firstNum, secondNum);
            } else {
                return firstNum;
            }
        } else {
            if (secondNum >= 10 && secondNum <= 20) {
                return secondNum;
            } else {
                return 0;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(max1020(11, 19));
        System.out.println(max1020(19, 11));
        System.out.println(max1020(11, 9));
        System.out.println(max1020(9, 21));
    }
}