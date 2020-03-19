package everyday;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 *
 * @Author xiaocan
 * @Date 2020/3/19 21:21
 **/
public class Question409 {
    public int longestPalindrome(String s) {
        //1。存储每个字符出现的次数
        int[] chars = new int[128];
        for (char ch : s.toCharArray()) {
            chars[ch]++;
        }

        //2。计算奇数个数的字符
        int count = 0;
        for (int v : chars) {
            count += v % 2;
        }

        //3。回文长度等于字符串长度减去奇数字符的个数+1（可以有一个奇数字符串出现在回文中间）
        return count == 0 ? s.length() : s.length() - count + 1;
    }

    public int longestPalindrome11(String s) {
        //1。存储每个字符出现的次数
        int[] chars = new int[128];
        for (char ch : s.toCharArray()) {
            chars[ch]++;
        }

        //2。计算偶数字符串的个数
        int count = 0;
        for (int v : chars) {
//            count += v / 2 * 2;
            // 还可以这样
            count += v - (v & 1);
        }

        //3。如果小于字符串的长度，说明有奇数字符串，那就加一
        return count < s.length() ? count + 1 : count;
    }

    public int longestPalindrome2(String s) {
        //1。 存储每个字符出现的次数
        int[] chars = new int[128];
        for (char ch : s.toCharArray()) {
            chars[ch]++;
        }

        //2。 回文的长度=偶数字符串的长度+1个奇数字符串的长度
        int count = 0;
        for (int v : chars) {
            count += v / 2 * 2;
            // 第一次出现奇数字符串加一，之后count就是奇数，不能再要奇数字符串了
            if (v % 2 == 1 && count % 2 == 0) {
                count += 1;
            }
        }

        return count;
    }

    public int longestPalindrome3(String s) {
        //1。使用 map 保存每个字符串的个数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        //2。之后的思路和上面的一样
        int count = 0;
        Collection<Integer> values = map.values();
        for (int v : values) {
            count += v % 2;
        }
        return count == 0 ? s.length() : s.length() - count + 1;
    }


    public static void main(String[] args) {
        Question409 question = new Question409();
        System.out.println(question.longestPalindrome3("abccccdd"));
    }
}
