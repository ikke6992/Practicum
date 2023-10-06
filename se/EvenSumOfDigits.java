package se;

public class EvenSumOfDigits {

    public static void main(String[] args) {

        for (int i = 100; i < 150; i++) {

            if (sumOfDigits(i) % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static int sumOfDigits(int number) {

        //length is the amount of digits number consists of
        int length = (int)(Math.log10(Math.abs(number)) + 1);
        int sum = 0;

        //adds every digit in number to sum
        for (int i = 0; i < length; i++) {
            sum += number / Math.pow(10, i);
        }

        return sum;
    }
}