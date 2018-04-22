package model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class Mars {
    private Pair<Byte, Byte> topRightCords;
    private List<Robot> robotsOnMars = new ArrayList<>();

    Mars(Byte x, Byte y) {
        this.topRightCords = new Pair<>(x, y);
    }

    /**
     * Check position with other robots
     *
     * @param position - current robot position
     * @return boolean - if current robot have the same position as one of lost robots
     */
    boolean otherRobotLost(RobotPosition position) {
        long count = robotsOnMars.stream().filter(robotOnMars -> robotOnMars.lostAndPosition(position)).count();
        return count > 0;
    }

    /**
     * Check position on the board
     *
     * @param position - current robot position
     * @return boolean - return true if position is off of board
     */
    boolean positionOffBoard(RobotPosition position) {
        return position.getCords().getKey() > topRightCords.getKey() || position.getCords().getKey() < 0 ||
                position.getCords().getValue() > topRightCords.getValue() || position.getCords().getValue() < 0;
    }

    /**
     * Adding robot to list
     *
     * @param robot - Robot to add to list
     */
    void addRobot(Robot robot) {
        this.robotsOnMars.add(robot);
    }

}
