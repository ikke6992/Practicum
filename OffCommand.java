public class OffCommand extends RobotCommand {
    
    public void run(Robot robot) {
        robot.isPowered = false;
    }
}