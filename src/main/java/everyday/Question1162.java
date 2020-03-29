package everyday;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 *
 * @Author xiaocan
 * @Date 2020/3/29 12:32
 **/
public class Question1162 {
    public int maxDistance(int[][] grid) {
        // 上下左右四个方向
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        // 所有陆地入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 从陆地开始，一圈圈遍历海洋，最后遍历到的海洋就是离陆地最远的海洋
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 超过边界或者不是海洋的话，遍历其它方向
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                // 把该点的值变成离陆地的距离，就不需要额外的数组记录是否访问过
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }

        // 没有陆地或者没有海洋，返回 -1
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一个遍历到的海洋的距离
        return grid[point[0]][point[1]] - 1;

    }
}
