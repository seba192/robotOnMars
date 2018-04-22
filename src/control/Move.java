package control;

import model.RobotPosition;

public interface Move {

    /**
     * Method change RobotPosition
     *
     * @param command  - current robot command
     * @param position - current robot position
     * @return boolean  - return false if position is out of board and true is position is on board
     */
    boolean move(Character command, RobotPosition position);

}
