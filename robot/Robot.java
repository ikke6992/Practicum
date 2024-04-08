package robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Robot {
    protected int x;
    
    protected int y;
    
    protected boolean isPowered;

    protected List<RobotCommand> commands = new ArrayList<>();

    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        Robot robot = new Robot();
        boolean keepGoing = true;
        
        while (keepGoing) {
            
            System.out.println("Input RobotCommand");
            String command = in.nextLine();
            
            switch(command) {
                case "on" -> robot.commands.add(new OnCommand());
                case "off" -> robot.commands.add(new OffCommand());
                case "north" -> robot.commands.add(new NorthCommand());
                case "south" -> robot.commands.add(new SouthCommand());
                case "west" -> robot.commands.add(new WestCommand());
                case "east" -> robot.commands.add(new EastCommand());
                case "stop" -> keepGoing = false;
                default -> System.out.println(command + " is an invalid command");
            }
        }
        
        robot.run();
    }
}