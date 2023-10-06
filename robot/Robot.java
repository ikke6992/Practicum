package robot;

import java.util.Scanner;

class Robot {
    protected int x;
    
    protected int y;
    
    protected boolean isPowered;

    protected RobotCommand[] commands = new RobotCommand[3];

    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Input three types of RobotCommand");
        String command1 = in.nextLine();
        String command2 = in.nextLine();
        String command3 = in.nextLine();
        
        Robot robot = new Robot();
        
        String[] commands = new String[]{command1, command2, command3};
        for (int i = 0; i < commands.length; i++) {
            switch(commands[i]) {
                case "on" -> robot.commands[i] = new OnCommand();
                case "off" -> robot.commands[i] = new OffCommand();
                case "north" -> robot.commands[i] = new NorthCommand();
                case "south" -> robot.commands[i] = new SouthCommand();
                case "west" -> robot.commands[i] = new WestCommand();
                case "east" -> robot.commands[i] = new EastCommand();
                default -> System.out.println(commands[i] + " is an invalid command");
            }
        }
        
        robot.run();
    }
}