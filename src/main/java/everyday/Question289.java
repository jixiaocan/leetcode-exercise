package everyday;

/**
 * 289. 生命游戏
 *
 * @Author xiaocan
 * @Date 2020/4/2 08:35
 **/
public class Question289 {
    public void gameOfLife(int[][] board) {
        int[] dx = new int[]{0, 0, 1, -1, -1, -1, 1, 1};
        int[] dy = new int[]{1, -1, 0, 0, -1, 1, -1, 1};
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int current = board[i][j];
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                        continue;
                    }
                    // 2-之前是活的，后来死了
                    if (board[newX][newY] == 1 || board[newX][newY] == 2) {
                        live++;
                    }
                }
                // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                if (current == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                if (current == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }

        // 奇数是活的，偶数是死的
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
