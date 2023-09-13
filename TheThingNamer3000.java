import java.util.Scanner;

public class TheThingNamer3000 {

    public static void main(String[] args) {

        System.out.println("What kind of thing are we talking about?");
        Scanner input = new Scanner(System.in);

        /*
         * String to store what the user named the thing
         * Receives the user's input from System.in
         */
        String a = input.nextLine();

        System.out.println("How would you describe it? Big? Azure? Tattered?");

        /*
         * String to store the user's description of the thing
         * Receives the user's input from System.in
         */
        String b = input.nextLine();

        //String that describes what the thing is of, currently 'Doom'
        String c = "Doom";

        //String that describes the version of the thing, current version '3000'
        String d = "3000";

        System.out.println("The " + b + " " + a + " of " + c + " " + d + "!");
    }
}