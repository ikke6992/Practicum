public class WestCommand extends RobotCommand {
    
    public void run(Robot robot) {
        if (robot.isPowered) {
            robot.x--;
        }
    }
}