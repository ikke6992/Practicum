import java.util.Scanner;

public class TakingANumber {

    /*
     * Controleert of de meegegeven String een getal is dmv parseInt
     * Zoniet dan catcht het de NumberFormatException en wordt de
     * return de minimum waarde die een integer kan hebben.
     *
     * Zou dit netter kunnen?
     */
    public static int askForNumber(String text) {

        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            result = Integer.MIN_VALUE;
        }
        return result;
    }

    /*
     * Controleert of de meegegeven String een getal is dmv parseInt
     * Zoniet dan catcht het de NumberFormatException en wordt de
     * return de minimum waarde die een integer kan hebben.
     * Zowel dan checkt het of het getal buiten de minimum en maximum
     * meegegeven waarde valt, en als dit zo is wordt de return ook
     * de minimum integer waarde.
     *
     * Zou dit netter kunnen?
     */
    public static int askForNumberInRange(String text, int min, int max) {
        int result;
        try {
            result = Integer.parseInt(text);
            if (result < min || result > max) {
                result = Integer.MIN_VALUE;
            }
        } catch (NumberFormatException e) {
            result = Integer.MIN_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int result = Integer.MIN_VALUE;


        /*
         * Blijft de gebruiker vragen om een nummer totdat de gebruiker 
         * daadwerkelijk een nummer ingevoerd heeft
         */
        do {
            System.out.print("Enter a number: ");
            String text = scanner.nextLine();
            result = askForNumber(text);
        } while (result == Integer.MIN_VALUE);

        System.out.println(result);
    }
}