package everyday;

/**
 * 892. 三维形体的表面积
 *
 * @Author xiaocan
 * @Date 2020/3/25 08:26
 **/
public class Question892 {
    public int surfaceArea(int[][] grid) {
        int count = 0;
        // 计算所有的总面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    // 上下两个面
                    int total = 2;
                    // 前后左右四个面
                    total += 4 * grid[i][j];

                    // 减去下面重叠的部分
                    if (i + 1 < grid.length) {
                        total -= Math.min(grid[i + 1][j], grid[i][j]) * 2;
                    }
                    // 减去右边重叠的部分
                    if (j + 1 < grid[i].length) {
                        total -= Math.min(grid[i][j + 1], grid[i][j]) * 2;
                    }
                    // 计算总数
                    count += total;
                }
            }
        }
        return count;
    }
}
