import java.util.Scanner;
import java.text.DecimalFormat;

public class Arrow {
    
    public enum Arrowhead {
        STEEL(10),
        WOOD(3),
        OBSIDIAN(5);
        
        private final int cost;
        
        Arrowhead(int cost) {
            this.cost = cost;
        }
        
        public int getCost() {
            return cost;
        }
    }
    
    public enum Fletching {
        PLASTIC(10),
        TURKEY(5),
        GOOSE(3);
        
        private final int cost;
        
        Fletching(int cost) {
            this.cost = cost;
        }
        
        public int getCost() {
            return cost;
        }
    }
    
    private static final int MIN_LENGTH = 60;
    private static final int MAX_LENGTH = 100;
    private static final DecimalFormat PRICE = new DecimalFormat("0.00");
    
    private Arrowhead arrowhead;
    private int length;
    private Fletching fletching;
    
    public Arrow(Arrowhead arrowhead, int length, Fletching fletching) {
        this.arrowhead = arrowhead;
        this.length = length;
        this.fletching = fletching;
    }
    
    public static Arrow createEliteArrow() {
        return new Arrow(Arrowhead.STEEL, 95, Fletching.PLASTIC);
    }
    
    public static Arrow createBeginnerArrow() {
        return new Arrow(Arrowhead.WOOD, 75, Fletching.GOOSE);
    }
    
    public static Arrow createMarksmanArrow() {
        return new Arrow(Arrowhead.STEEL, 65, Fletching.GOOSE);
    }
    
    public float getCost() {
        
        float price = 0f;
        price += arrowhead.getCost();
        price += fletching.getCost();
        price += length * 0.05;
        
        return price;
    }
    
    public int getLength() {
        return length;
    }
    
    public Arrowhead getArrowhead() {
        return arrowhead;
    }
    
    public Fletching getFletching() {
        return fletching;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Arrowhead arrowhead = Arrowhead.WOOD;
        Fletching fletching = Fletching.GOOSE;
        Arrow arrow;
        
        System.out.println("Would you like to use one of the following presets?\n" +
            "Options: elite, beginner, marksman");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("elite")) {
            arrow = Arrow.createEliteArrow();
        } else if (input.toLowerCase().equals("beginner")) {
            arrow = Arrow.createBeginnerArrow();
        } else if (input.toLowerCase().equals("marksman")) {
            arrow = Arrow.createMarksmanArrow();
        } else {
            
            boolean valid = false;
            do {
                System.out.println("Input arrowhead type. Options: steel, wood, obsidian");
                input = scanner.nextLine();
                
                if (input.toLowerCase().equals("steel")) {
                    arrowhead = arrowhead.STEEL;
                    valid = true;
                } else if (input.toLowerCase().equals("wood")) {
                    arrowhead = arrowhead.WOOD;
                    valid = true;
                } else if (input.toLowerCase().equals("obsidian")) {
                    arrowhead = arrowhead.OBSIDIAN;
                    valid = true;
                }
            } while(!valid);
            
            valid = false;
            do {
                System.out.println("Input fletching. Options: plastic, turkey, goose");
                input = scanner.nextLine();
                
                if (input.toLowerCase().equals("plastic")) {
                    fletching = fletching.PLASTIC;
                    valid = true;
                } else if (input.toLowerCase().equals("turkey")) {
                    fletching = fletching.TURKEY;
                    valid = true;
                } else if (input.toLowerCase().equals("goose")) {
                    fletching = fletching.GOOSE;
                    valid = true;
                }
            } while(!valid);
            
            int length = Integer.MIN_VALUE;
            do {
            System.out.printf("How long should the shaft of the arrow be?\n" +
                "Input length between %d and %d: ", MIN_LENGTH, MAX_LENGTH);
            length = TakingANumber.askForNumberInRange(scanner.nextLine(), MIN_LENGTH, MAX_LENGTH);
            } while (length == Integer.MIN_VALUE);
            
            arrow = new Arrow(arrowhead, length, fletching);
        }
        
        System.out.printf("The price of your arrow is %s", PRICE.format(arrow.getCost()));
    }

}