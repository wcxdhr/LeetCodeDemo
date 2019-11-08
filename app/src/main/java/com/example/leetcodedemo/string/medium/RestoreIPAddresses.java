package com.example.leetcodedemo.string.medium;
/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/10/24.
 */
public class RestoreIPAddresses {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        ipHelper(s, 0, 3, new StringBuilder());
        return ans;
    }

    private void ipHelper(String s, int index, int count, StringBuilder builder) {
        if (count == 0) {
            if (index < s.length()) {
                int num = Integer.parseInt(s.substring(index));
                if (num < 256 && String.valueOf(num).length() == s.length() - index) {
                    builder.append(num);
                    ans.add(builder.toString());
                    builder.delete(builder.length() - String.valueOf(num).length(), builder.length());
                }
            }
        }

        else {
            for (int i = 1; i < 4; i++) {
                if (index + i < s.length() && count * 3 >= s.length() - index - i) {
                    int num = Integer.parseInt(s.substring(index, index + i));
                    if (num < 256 && String.valueOf(num).length() == i) {
                        builder.append(num + ".");
                        ipHelper(s, index + i, count - 1, builder);
                        builder.delete(builder.length() - String.valueOf(num).length() - 1, builder.length());
                    }
                }
            }
        }
    }
}
