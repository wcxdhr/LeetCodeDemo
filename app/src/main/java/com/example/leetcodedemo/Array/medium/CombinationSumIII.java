package com.example.leetcodedemo.Array.medium;
/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/9/25.
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3,9));
    }

    List<List<Integer>> ans = new ArrayList<>();


    /**
     * 优化空间：对list使用remove和add来避免大量创建实例
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10 - k; i++) {
            findSum(k, n, i, list);
        }
        return ans;
    }

    private void findSum(int k, int n, int index, List<Integer> list) {
        if (k > 1) {
            for (int i = index; i < 9; i++) {
                if (n - index > index) {
                    list.add(index);
                    findSum(k - 1, n - index, i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
        else if (k == 1 && n - index == 0) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(index);
            ans.add(newList);
        }
    }
}
