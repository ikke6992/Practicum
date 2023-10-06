public class EastCommand implements RobotCommand {
    
    public void run(Robot robot) {
        if (robot.isPowered) {
            robot.x++;
        }
    }
}