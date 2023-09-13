public class EveryNth {

    public static String everyNth(String text, int number) {

        String result = "";

        for (int i = 0; i < text.length(); i += number) {
            result += text.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(everyNth("Miracle", 2));
        System.out.println(everyNth("abcdefg", 2));
        System.out.println(everyNth("abcdefg", 3));
        System.out.println(everyNth("", 2));
    }
}