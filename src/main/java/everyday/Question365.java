package everyday;

/**
 * 365. 水壶问题
 *
 * @Author xiaocan
 * @Date 2020/3/21 09:26
 **/
public class Question365 {
    //思路：找到 x 和 y 的最大公约数，判断 z 是否使它的倍数
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0) return z == 0;
        return z == 0 || (z % gcd(x, y) == 0 && x + y >= z);
    }

    // 计算 x 和 y 的最大公约数
    int gcd(int x, int y) {
        if (y == 0) return x;
        int r = x % y;
        return gcd(y, r);
    }
}
