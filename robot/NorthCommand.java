package robot;

public class NorthCommand implements RobotCommand {
    
    public void run(Robot robot) {
        if (robot.isPowered) {
            robot.y++;
        }
    }
}