package model;

import control.Move;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Mars {
    private Pair<Byte, Byte> topRightCords;
    private List<Robot> robotsOnMars = new ArrayList<>();
    private Move move;

    public Mars(Byte x, Byte y, Move move) {
        this.topRightCords = new Pair<>(x, y);
        this.move = move;
        this.move.setMars(this);
    }

    public boolean robotTryAndLose(Robot robot) {
        long count = robotsOnMars.stream().filter(robotOnMars ->
                robotOnMars.getLost() &&
                        robotOnMars.getOrientation().equals(robot.getOrientation()) &&
                        robotOnMars.getCords().getKey().equals(robot.getCords().getKey()) &&
                        robotOnMars.getCords().getValue().equals(robot.getCords().getValue())
        ).count();
        return count == 0;
    }

    public boolean positionOffBoard(Pair<Byte, Byte> cord) {
        return cord.getKey() > topRightCords.getKey() || cord.getKey() < 0 ||
                cord.getValue() > topRightCords.getValue() || cord.getValue() < 0;
    }

    public void moveRobot(Robot robot) {
        move.move(robot);
        robotsOnMars.add(robot);
    }
}
