package robot;

public class WestCommand implements RobotCommand {
    
    public void run(Robot robot) {
        if (robot.isPowered) {
            robot.x--;
        }
    }
}