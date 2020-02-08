package com.example.leetcodedemo.offercode;
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * Created by wcxdhr on 2020/2/5.
 */

public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer().append("We Are Happy")));

    }

    /**
     * 书上的意思是必须在原字符串上修改，且不能用o(n2)的算法，而是o(n)
     * 以下官方解答
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int len = str.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ')
                num++;
        }
        int newLen = len + num * 2;
        str.setLength(newLen);
        int oldP = len - 1;
        int newP = newLen - 1;
        while (oldP >= 0) {
            if (str.charAt(oldP) == ' '){
                str.setCharAt(newP--, '0') ;
                str.setCharAt(newP--, '2') ;
                str.setCharAt(newP--, '%') ;
                oldP--;
            }
            else
                str.setCharAt(newP--, str.charAt(oldP--)) ;
        }
        return str.toString();
    }

    /**
     * 我的思路：直接开辟新的内存（笑哭）
     * @param str
     * @return
     */
    public String replaceSpace1(StringBuffer str) {
        int len = str.length();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < len) {
            char c = str.charAt(i);
            if ( c == ' ') {
                builder.append("%20");
            }
            else builder.append(c);
            i++;
        }
        return builder.toString();
    }
}
