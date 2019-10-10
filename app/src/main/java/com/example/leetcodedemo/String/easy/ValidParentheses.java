package com.example.leetcodedemo.String.easy;
/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Wcxdhr on 2019/10/10.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        for (int i = 0; i < s.length(); i++) {
             if (map.containsKey(s.charAt(i)))
                 stack.push(s.charAt(i));
             else if (stack.empty() || map.get(stack.pop()) != s.charAt(i))
                 return false;
        }
        return stack.empty() ? true : false;
    }
}
