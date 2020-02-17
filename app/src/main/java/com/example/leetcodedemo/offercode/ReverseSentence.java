package com.example.leetcodedemo.offercode;
/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

/**
 * Created by wcxdhr on 2020-02-17.
 */
public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence(null));
    }

    /**
     * 书上想要的解法是先翻转整个字符串，再分别翻转每个单词，需要一个reverse函数来帮助。
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        String[] strings = str.split(" ");
        if (strings.length <= 1)
            return str;
        String ans = "";
        for (int i = strings.length - 1; i >= 1; i--) {
            ans += strings[i] + " ";
        }
        ans += strings[0];
        return ans;
    }
}
