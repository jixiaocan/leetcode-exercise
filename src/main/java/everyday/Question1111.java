package everyday;

/**
 * 1111. 有效括号的嵌套深度
 * @Author xiaocan
 * @Date 2020/4/1 08:21
 **/
public class Question1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : (idx + 1) & 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 偶数返回0，奇数返回1
        System.out.println(2 & 1);
        System.out.println(3 & 1);
        System.out.println(4 & 1);
    }

}
