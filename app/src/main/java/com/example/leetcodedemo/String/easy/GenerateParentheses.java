package com.example.leetcodedemo.String.easy;
/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/10/12.
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesisHelper(n, "", 0, 0);
        return ans;
    }

    private void generateParenthesisHelper(int n, String s, int leftCount, int rightCount) {
        if (leftCount == n && rightCount == n)
            ans.add(s);
        else {
            if (leftCount < n) {
                s += "(";
                generateParenthesisHelper(n, s, ++leftCount, rightCount);
                s = s.substring(0, s.length() - 1);
                --leftCount;
            }
            if (rightCount < n && leftCount > rightCount) {
                s += ")";
                generateParenthesisHelper(n, s, leftCount, ++rightCount);
            }
        }
    }
}
