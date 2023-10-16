public class TheMagicCannon {

    public enum Colour {
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

        Colour(String code) {
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
                fire += Colour.CYAN + "Electric Fire" + Colour.RESET;
            } else {
                fire += Colour.RED + "Fire" + Colour.RESET;
            }
        } else if (i % 5 == 0) {
            fire += Colour.YELLOW + "Electric" + Colour.RESET;
        } else {
            fire += "Normal";
        }
        return fire;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            System.out.println(fire(i));
        }

    }
}