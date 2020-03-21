package everyday;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 40. 最小的k个数
 *
 * @Author xiaocan
 * @Date 2020/3/20 07:52
 **/
public class Question40 {
    // 使用快排，改变了原数组，时间 O(NlogN) 空间 O(1)
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }


    // 使用最大堆，适用于大量数据 时间 O(NlogK) 空间 O(K)
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            heap.add(e);
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }
}
