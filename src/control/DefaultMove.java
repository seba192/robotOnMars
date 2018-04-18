package control;

import javafx.util.Pair;
import model.Robot;

public class DefaultMove extends Move {

    public void move(Robot robot) {
        for (Character command : robot.getCommands()) {
            if (robot.getLost()) {
                break;
            }
            switch (command) {
                case 'F':
                    goForward(robot);
                    break;
                case 'L':
                    goLeft(robot);
                    break;
                case 'R':
                    goRight(robot);
                    break;
            }
        }
    }

    protected void goForward(Robot robot) {
        byte x = robot.getCords().getKey();
        byte y = robot.getCords().getValue();

        switch (robot.getOrientation()) {
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
        Pair<Byte, Byte> newPosition = new Pair<>(x, y);

        if (mars.robotTryAndLose(robot)) {
            robot.setLost(mars.positionOffBoard(newPosition));
            robot.setCords(newPosition);
        }
    }

    protected void goLeft(Robot robot) {
        switch (robot.getOrientation()) {
            case 'N':
                robot.setOrientation('W');
                break;
            case 'S':
                robot.setOrientation('E');
                break;
            case 'W':
                robot.setOrientation('S');
                break;
            case 'E':
                robot.setOrientation('N');
                break;
        }
    }

    protected void goRight(Robot robot) {
        switch (robot.getOrientation()) {
            case 'N':
                robot.setOrientation('E');
                break;
            case 'S':
                robot.setOrientation('W');
                break;
            case 'W':
                robot.setOrientation('N');
                break;
            case 'E':
                robot.setOrientation('S');
                break;
        }
    }
}
