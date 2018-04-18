package model;

import javafx.util.Pair;

public class Robot {
    private Pair<Byte, Byte> cords;
    private Character orientation;
    private Boolean lost = false;
    private char[] commands;

    public Robot(Byte x, Byte y, Character orientation, char[] commands) {
        this.cords = new Pair<>(x, y);
        this.orientation = orientation;
        this.commands = commands;
    }

    public String getPosition() {
        return cords.getKey() + " " + cords.getValue() + " " + orientation + (lost ? " LOST" : "");
    }

    public char[] getCommands() {
        return commands;
    }

    public Pair<Byte, Byte> getCords() {
        return cords;
    }

    public Character getOrientation() {
        return orientation;
    }

    public Boolean getLost() {
        return lost;
    }

    public void setCords(Pair<Byte, Byte> cords) {
        if (lost) {
            return;
        }
        this.cords = cords;
    }

    public void setOrientation(Character orientation) {
        if (lost) {
            return;
        }
        this.orientation = orientation;
    }

    public void setLost(Boolean lost) {
        this.lost = lost;
    }

}
