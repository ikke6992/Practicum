public class CreateThreeDigitNumbers {

    public static void main(String[] args) {

        int counter = 0;

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i != j) {
                    for (int k = 1; k <= 4; k++) {
                        if (k != i && k != j) {
                            System.out.printf("%d%d%d\n", i, j, k);
                            counter++;
                        }
                    }
                }
            }
        }

        System.out.println("Total number of three-digit-numbers is " + counter);
    }
}