package everyday;

/**
 * 999. 车的可用捕获量
 *
 * @Author xiaocan
 * @Date 2020/3/26 13:58
 **/
public class Question999 {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        // 分别计算上下左右四个方向可以吃到的卒
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    // 左边
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            count++;
                            break;
                        }
                    }

                    // 右边
                    for (int k = j + 1; k < 8; k++) {
                        if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            count++;
                            break;
                        }
                    }

                    // 上面
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            count++;
                            break;
                        }
                    }

                    // 下面
                    for (int k = i + 1; k < 8; k++) {
                        if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            count++;
                            break;
                        }
                    }

                    return count;
                }

            }

        }
        return count;
    }
}