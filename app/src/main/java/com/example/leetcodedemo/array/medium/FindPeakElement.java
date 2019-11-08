package com.example.leetcodedemo.array.medium;
/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/24.
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{1,2}));
    }


    boolean notFound = true;

    /**
     * 优化：根据题中给出的数组左右两端的性质，可知若nums[mid] < nums[mid + 1] 右边必有峰值，左边亦然。
     * 二分查找
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1)
            return 0;
        return findPeakElementHelper(nums, 0, nums.length - 1);
    }

    private int findPeakElementHelper(int[] nums, int left, int right) {
        if (notFound) {
            if (left <= right) {
                int mid = (left + right) / 2;
                if (mid == 0 ) {
                    if (nums[mid] > nums[mid + 1]) {
                        notFound = false;
                        return mid;
                    }
                }
                else if (mid == nums.length - 1){
                    if (nums[mid] > nums[mid - 1]) {
                        notFound = false;
                        return mid;
                    }
                }
                else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    notFound = false;
                    return mid;
                }
                return findPeakElementHelper(nums, mid + 1, right) + findPeakElementHelper(nums, left, mid - 1);
            }
            return 0;
        }
        else
            return 0;
    }
}
