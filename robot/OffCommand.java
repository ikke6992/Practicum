package robot;

public class OffCommand implements RobotCommand {
    
    public void run(Robot robot) {
        robot.isPowered = false;
    }
}