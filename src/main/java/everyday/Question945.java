package everyday;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 *
 * @Author xiaocan
 * @Date 2020/3/22 09:35
 **/
public class Question945 {
    public int minIncrementForUnique(int[] A) {
        //用来统计的数组需要是80000
        int[] count = new int[80000];
        for (int x : A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                // 记录有多少重复的数
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                // 如果这个数没有出现，将之前重复的数增加到它
                taken--;
                ans += x;
            }
        }
        return ans;
    }

    public int minIncrementForUnique2(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                A[i]++;
                res++;
            } else if (A[i] < A[i - 1]) {
                res += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1, 2, 1, 7};
        Question945 question = new Question945();
        int count = question.minIncrementForUnique(A);
        System.out.println(count);
    }
}
