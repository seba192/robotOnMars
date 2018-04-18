package control;

import model.Mars;
import model.Robot;

public abstract class Move {
    protected Mars mars;

    public void setMars(Mars mars) {
        this.mars = mars;
    }

    public abstract void move(Robot robot);

    protected abstract void goLeft(Robot robot);

    protected abstract void goRight(Robot robot);

    protected abstract void goForward(Robot robot);
}
