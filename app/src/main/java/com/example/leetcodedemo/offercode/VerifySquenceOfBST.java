package com.example.leetcodedemo.offercode;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */


/**
 * Created by wcxdhr on 2020-02-12.
 */
public class VerifySquenceOfBST {


    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{4,6,12,16,14,10}));
    }

    /**
     * 先序遍历：遍历顺序规则为【根左右】
     *
     * 中序遍历：遍历顺序规则为【左根右】
     *
     * 后序遍历：遍历顺序规则为【左右根】
     * 搞清楚啊，后序遍历不是先遍历右子树
     *
     * 典型用递归处理，这三种遍历方式首先想到递归
     * 注意边界处理，小于还是小于等于
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return VerifyHelper(sequence, 0, sequence.length - 1);
    }

    private boolean VerifyHelper(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int root = sequence[end];
        int i;
        for (i = start; i < end; i++)
            if (sequence[i] > root)
                break;
        for (int j = i; j < end; j++)
            if (sequence[j] < root)
                return false;
        return VerifyHelper(sequence, start, i - 1) && VerifyHelper(sequence, i, end - 1);
    }
}
