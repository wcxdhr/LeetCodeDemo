package com.example.leetcodedemo.offercode;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */

/**
 * Created by wcxdhr on 2020-02-22.
 */
public class MultiplyArray {

    /**
     * 本题无思路：书上解答：可以将每一个乘积分为两部分，一部分是0~i-1,另一部分是i+1~n-1
     * 进一步数组B可以用一个矩阵来创建，对角线元素A[i]都为1。
     * 定义C[i] = A[0]*...*A[i-1],D[i] = A[i+1]*...*A[n-1]
     * C[i]可以自上而下地计算出来，即C[i] = C[i-1]*A[i-1]
     * D[i]同理，自下而上
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (len > 1) {
            B[0] = 1;
            for (int i = 1; i < len; i++)
                B[i] = A[i - 1] * B[i - 1];
            int temp = 1;
            for (int i = len - 2; i >= 0; i--) {
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;
    }
}
