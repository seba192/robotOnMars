package model;

public class SingletonMars {
    private static Mars instance = null;

    private SingletonMars() {
    }

    public static Mars getInstance(Byte x, Byte y) {
        if (instance == null) {
            instance = new Mars(x, y);
        }
        return instance;
    }

    public static Mars getInstance() {
        return getInstance(Byte.valueOf("0"), Byte.valueOf("0"));
    }

    public static void addRobotToMars(Robot robot) {
        getInstance().addRobot(robot);
    }

    public static boolean otherRobotLost(RobotPosition position) {
        return getInstance().otherRobotLost(position);
    }

    public static boolean positionOffBoard(RobotPosition position) {
        return getInstance().positionOffBoard(position);
    }
}
