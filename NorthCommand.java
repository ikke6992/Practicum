public class NorthCommand extends RobotCommand {
    
    public void run(Robot robot) {
        if (robot.isPowered) {
            robot.y++;
        }
    }
}