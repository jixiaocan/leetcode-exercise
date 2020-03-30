package everyday;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * @Author xiaocan
 * @Date 2020/3/30 08:36
 **/
public class Question62 {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1)
            return 0;
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question62 question62 = new Question62();
        int result = question62.lastRemaining2(41, 3);
        System.out.println(result);
    }
}
