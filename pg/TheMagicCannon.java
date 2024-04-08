package pg;

public class TheMagicCannon {

    public enum Color {
        RESET("\033[0m"),
        BLACK("\033[0;30m"),
        RED("\033[0;31m"),
        GREEN("\033[0;32m"),
        YELLOW("\033[0;33m"),
        BLUE("\033[0;34m"),
        MAGENTA("\033[0;35m"),
        CYAN("\033[0;36m"),
        WHITE("\033[0;37m");

        private final String code;

        private Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    public static String fire(int i) {

        String fire = i + ": ";

        if (i % 3 == 0) {
            if (i % 5 == 0) {
                fire += colorString("Electric Fire", Color.CYAN);
            } else {
                fire += colorString("Fire", Color.RED);
            }
        } else if (i % 5 == 0) {
            fire += colorString("Electric", Color.YELLOW);
        } else {
            fire += "Normal";
        }
        return fire;
    }
    
    public static String colorString(String toColor, Color color) {
        return new String(color + toColor + Color.RESET);
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            System.out.println(fire(i));
        }

    }
}