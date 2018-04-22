import control.DefaultMove;
import model.Robot;
import model.SingletonMars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotsOnMars {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //TODO Validate input
            String[] map = reader.readLine().split(" ");
            SingletonMars.getInstance(Byte.valueOf(map[0]), Byte.valueOf(map[1]));
            while (true) {
                String[] robotPosition = reader.readLine().split(" ");
                char[] robotCommands = reader.readLine().toCharArray();

                Robot robot = new Robot(
                        Byte.valueOf(robotPosition[0]),
                        Byte.valueOf(robotPosition[1]),
                        robotPosition[2].charAt(0),
                        robotCommands,
                        new DefaultMove());
                System.out.println(robot.move());
                SingletonMars.addRobotToMars(robot);
                //TODO Brake loop
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
