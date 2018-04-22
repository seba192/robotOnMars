package model;

import control.Move;
import javafx.util.Pair;

public class Robot {
    private RobotPosition position;
    private Boolean lost = false;
    private char[] commands;
    private Move move;

    public Robot(Byte x, Byte y, Character orientation, char[] commands, Move move) {
        this.position = new RobotPosition()
                .cords(new Pair<>(x, y))
                .orientation(orientation);
        this.commands = commands;
        this.move = move;
    }

    /**
     * Execute all commands
     *
     * @return String - position after work
     */
    public String move() {
        for (Character command : commands) {
            if (lost = move.move(command, position)) {
                break;
            }
        }

        return position.toString() + (lost ? " LOST" : "");
    }

    /**
     * Check current robot is lost and have the same position
     *
     * @param position - other robot position
     * @return boolean - return true id current robot is lost and have the same position
     */
    public boolean lostAndPosition(RobotPosition position) {
        return lost && this.position.equals(position);
    }
}
