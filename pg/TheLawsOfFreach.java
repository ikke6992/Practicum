package pg;

public class TheLawsOfFreach {

    public static void main(String[] args) {

        int[] array = {4, 51, -7, 13, -99, 15, -8, 45, 90};
        int currentSmallest = Integer.MAX_VALUE; // Start higher than any number in the array.
        int total = 0;
        for (int number : array) {
            total += number;
            if (number < currentSmallest)
                currentSmallest = number;
        }
        System.out.println(currentSmallest);

        double average = (double) total / array.length;
        System.out.println(average);
    }
}