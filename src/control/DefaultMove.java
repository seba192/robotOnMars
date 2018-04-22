package control;

import javafx.util.Pair;
import model.RobotPosition;
import model.SingletonMars;

public class DefaultMove implements Move {

    @Override
    public boolean move(Character command, RobotPosition position) {
        RobotPosition newPosition = null;
        switch (command) {
            case 'F':
                newPosition = goForward(position);
                break;
            case 'L':
                newPosition = goLeft(position);
                break;
            case 'R':
                newPosition = goRight(position);
                break;
        }

        if (SingletonMars.otherRobotLost(position) || newPosition == null) {
            newPosition = position;
        }

        if (SingletonMars.positionOffBoard(newPosition)) {
            return true;
        }

        position
                .cords(newPosition.getCords())
                .orientation(newPosition.getOrientation());

        return false;
    }

    /**
     * Method moves the robot forward
     *
     * @param position - current position
     * @return RobotPosition - return new roboto position
     */
    private RobotPosition goForward(RobotPosition position) {
        byte x = position.getCords().getKey();
        byte y = position.getCords().getValue();

        switch (position.getOrientation()) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
            case 'E':
                x++;
                break;
        }
        return new RobotPosition().cords(new Pair<>(x, y)).orientation(position.getOrientation());
    }

    /**
     * Method moves the robot left
     *
     * @param position - current position
     * @return RobotPosition - return new roboto position
     */
    private RobotPosition goLeft(RobotPosition position) {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('W');
                break;
            case 'S':
                position.setOrientation('E');
                break;
            case 'W':
                position.setOrientation('S');
                break;
            case 'E':
                position.setOrientation('N');
                break;
        }
        return position;
    }

    /**
     * Method moves the robot right
     *
     * @param position - current position
     * @return RobotPosition - return new roboto position
     */
    private RobotPosition goRight(RobotPosition position) {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('E');
                break;
            case 'S':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('N');
                break;
            case 'E':
                position.setOrientation('S');
                break;
        }
        return position;
    }

}
