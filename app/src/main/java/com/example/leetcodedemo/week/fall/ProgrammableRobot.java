package com.example.leetcodedemo.week.fall;

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/9/24.
 */

public class ProgrammableRobot {

    public static void main(String[] args) {
        ProgrammableRobot robot = new ProgrammableRobot();
        int[][] o = new int[][]{{4,2}};
        System.out.println(robot.robot("URR", o, 3,2));

    }


    public boolean robot(String command, int[][] obstacles, int x, int y) {
        for (int i = 0; i < obstacles.length - 1; i++){
            for (int j = i + 1; j < obstacles.length; j++) {
                if (obstacles[i][0] > obstacles[j][0]) {
                    int tmp = obstacles[i][0];
                    obstacles[i][0] = obstacles[j][0];
                    obstacles[j][0] = tmp;
                    tmp = obstacles[i][1];
                    obstacles[i][1] = obstacles[j][1];
                    obstacles[j][1] = tmp;
                }
            }
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            if (!indexMap.containsKey(obstacles[i][0]))
                indexMap.put(obstacles[i][0], i);
        }
        if (obstacles.length == 0)
            return true;
        int i = 0;
        int j = 0;
        int t = 0;
        while (true) {
            if (command.charAt(t++) == 'U')
                j++;
            else
                i++;
            if (i == x && y == j)
                return true;
            else if (i > x || j > x)
                return false;
            if (indexMap.containsKey(i)) {
                for (int index = indexMap.get(i); index < obstacles.length; index++) {
                    if (obstacles[index][0] > obstacles[indexMap.get(i)][0])
                        break;
                    if (obstacles[index][1] == j)
                        return false;
                }
            }
            if (t == command.length())
                t = 0;
        }
    }
}
