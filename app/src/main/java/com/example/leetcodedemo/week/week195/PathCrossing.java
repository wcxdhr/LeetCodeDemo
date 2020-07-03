package com.example.leetcodedemo.week.week195;
/**
 * 5448. 判断路径是否相交 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，
 * 分别表示向北、向南、向东、向西移动一个单位。
 *
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，
 * 请返回 True ；否则，返回 False 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * 示例 2：
 *
 *
 *
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 *
 *
 * 提示：
 *
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by wcxdhr on 2020-06-28.
 */
public class PathCrossing {

    public static void main(String[] args) {
        System.out.println(new PathCrossing().isPathCrossing("NESWW"));
    }

    class Coor {
        int x;
        int y;
    }

    public boolean isPathCrossing(String path) {
        int len = path.length();
        HashSet<String> set = new HashSet<>();
        int x, y;
        x = y = 0;
        set.add("00");
        for (int i = 0; i < len; i++) {
            char d = path.charAt(i);
            if (d == 'N') y++;
            else if (d == 'S') y--;
            else if (d == 'E') x++;
            else if (d == 'W') x--;
            if (set.contains(String.valueOf(x) + String.valueOf(y)))
                return true;
            else
                set.add(String.valueOf(x) + String.valueOf(y));
        }
        return false;
    }
}
