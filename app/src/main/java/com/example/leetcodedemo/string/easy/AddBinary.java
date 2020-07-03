package com.example.leetcodedemo.string.easy;
/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: Allocation = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: Allocation = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/12.
 */
public class AddBinary {
    /**
     * 代码优化：长度补齐，参考链表的加法
     * 参考：使用StringBuilder
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = flag;
            sum += i >= 0 ? a.charAt(i--) - 48 : 0;
            sum += j >= 0 ? b.charAt(j--) - 48 : 0;
            ans.append(sum & 1);
            flag = sum / 2;
        }
        ans.append(flag == 1 ? flag : "");
        return ans.reverse().toString();
    }
}
