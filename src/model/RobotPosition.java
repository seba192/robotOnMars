package model;

import javafx.util.Pair;

import java.util.Objects;

public class RobotPosition {
    private Pair<Byte, Byte> cords;
    private Character orientation;

    public Pair<Byte, Byte> getCords() {
        return cords;
    }

    public void setCords(Pair<Byte, Byte> cords) {
        this.cords = cords;
    }

    public Character getOrientation() {
        return orientation;
    }

    public void setOrientation(Character orientation) {
        this.orientation = orientation;
    }

    public RobotPosition cords(Pair<Byte, Byte> cords) {
        this.cords = cords;
        return this;
    }

    public RobotPosition orientation(Character orientation) {
        this.orientation = orientation;
        return this;
    }

    @Override
    public String toString() {
        return cords.getKey() + " " + cords.getValue() + " " + orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotPosition that = (RobotPosition) o;
        return Objects.equals(cords, that.cords) &&
                Objects.equals(orientation, that.orientation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cords, orientation);
    }
}
