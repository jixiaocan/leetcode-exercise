package everyday;

/**
 * 面试题 17.16. 按摩师
 *
 * @Author xiaocan
 * @Date 2020/3/24 20:07
 **/
public class Interview17 {
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
