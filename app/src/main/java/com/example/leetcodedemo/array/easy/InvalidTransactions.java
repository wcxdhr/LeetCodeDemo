package com.example.leetcodedemo.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果出现下述两种情况，交易 可能无效：
 *
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 示例 2：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 示例 3：
 *
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 *  
 *
 * 提示：
 *
 * transactions.length <= 1000
 * 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
 * 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
 * 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invalid-transactions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvalidTransactions {

    public static void main(String[] args) {
        System.out.println(invalidTransactions(new String[]{"xnova,261,1949,chicago","bob,206,1284,chicago","xnova,420,996,bangkok","chalicefy,704,1269,chicago","iris,124,329,bangkok","xnova,791,700,amsterdam","chalicefy,572,697,budapest","chalicefy,231,310,chicago","chalicefy,763,857,chicago","maybe,837,198,amsterdam","lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","lee,607,275,budapest","chalicefy,709,1171,amsterdam"}));
    }

    /**
     * 题目说返回任意顺序，实测顺序不一样不通过。
     * @param transactions
     * @return
     */
    public static List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        String[][] transArr = new String[transactions.length][4];
        boolean[] flags = new boolean[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            transArr[i] = transactions[i].split(",");
            for (int j = 0; j < i; j++) {
                if (transArr[i][0].equals(transArr[j][0])
                        && !transArr[i][3].equals(transArr[j][3])
                        && Math.abs(Integer.parseInt(transArr[i][1]) - Integer.parseInt(transArr[j][1])) <= 60) {
                    if (!flags[j]) {
                        ans.add(transactions[j]);
                        flags[j] = true;
                    }
                    if (!flags[i]) {
                        ans.add(transactions[i]);
                        flags[i] = true;
                    }
                }
            }
            if (Integer.parseInt(transArr[i][2]) >= 1000 && !flags[i]) {
                ans.add(transactions[i]);
                flags[i] = true;
            }
        }
        return ans;
    }
}
