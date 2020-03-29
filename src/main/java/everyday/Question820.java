package everyday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author xiaocan
 * @Date 2020/3/28 20:58
 **/
public class Question820 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> all = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                all.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String word : all) {
            ans += word.length() + 1;
        }
        return ans;

    }
}
