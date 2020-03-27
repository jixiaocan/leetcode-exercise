package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 914. 卡牌分组
 *
 * @Author xiaocan
 * @Date 2020/3/27 08:36
 **/
public class Question914 {
    public boolean hasGroupsSizeX(int[] deck) {
        // 如果存在，那么必然是卡牌总数的约数，也是每个卡牌总数的约数
        int N = deck.length;
        int[] deckCount = new int[10000];
        for (int d : deck) {
            deckCount[d]++;
        }

        // 取出总数大于0卡牌数量
        List<Integer> list = new ArrayList<>();
        for (int count : deckCount) {
            if (count > 0) {
                list.add(count);
            }
        }

        search:
        for (int X = 2; X <= N; X++) {
            if (N % X == 0) {
                for (int count : list) {
                    if (count % X != 0) {
                        continue search;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // 计算最大公约数
    public boolean hasGroupsSizeX2(int[] deck) {
        int[] deckCount = new int[10000];
        for (int d : deck) {
            deckCount[d]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; ++i) {
            if (deckCount[i] > 0) {
                if (g == -1)
                    g = deckCount[i];
                else
                    g = gcd(g, deckCount[i]);
            }
        }

        return g >= 2;
    }


    // 计算 x 和 y 的最大公约数
    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public static void main(String[] args) {
        int[] deck = new int[]{1, 1};
        Question914 question = new Question914();
        boolean b = question.hasGroupsSizeX(deck);
        System.out.println(b);
    }
}
