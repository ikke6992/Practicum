package se;

public class NotString {
    
    public static String notString(String string) {
        if (string.length() >= 3 && string.substring(0, 3).equals("not")) {
            return string;
        } else {
            return "not " + string;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(notString("candy"));
        System.out.println(notString("x"));
        System.out.println(notString("not bad"));
        System.out.println(notString("not"));
    }
}