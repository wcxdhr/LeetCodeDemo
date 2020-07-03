package com.example.leetcodedemo.array.easy;
/**
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class FindCommonCharacters {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bdgfhthkjvgh"}));
    }

    /**
     * 直接使用String，去除char的转换
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        int[][] wordCount = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                wordCount[i][(A[i].charAt(j)) - 'a']++;
            }
        }
        List<String> chars = new ArrayList<>();
        int j = 0;
        while (j < 26){
            boolean flag = true;
            while (flag) {
                for (int i = 0; i < A.length; i++) {
                    if (wordCount[i][j] == 0) {
                        flag = false;
                        break;
                    }
                    else
                        wordCount[i][j]--;
                    if (i == A.length - 1)
                        chars.add(String.valueOf((char)(j + 'a')));
                }
            }
            j++;
        }
        return chars;
    }
}
