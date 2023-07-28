package main.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    // 方向
    int[][] positions = new int[][]{
            new int[]{-1, -1},
            new int[]{1, 1},
            new int[]{1, -1},
            new int[]{-1, 1},
            new int[]{0, 1},
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
    };

    List<List<String>> allBroads = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] broad = new char[n][n];
        for (char[] chars : broad) {
            Arrays.fill(chars, '.');
        }
        backTrack(n, broad, 0);
        return allBroads;
    }

    private void backTrack(int choices, char[][] broad, int row) {
        // 皇后已经放置完了
        if (choices == 0) {
            allBroads.add(charArrayToStr(broad));
            return;
        }

        for (int i = 0; i < broad[0].length; i++) {
            if (!isValid(broad, row, i)) {
                continue;
            }
            broad[row][i] = 'Q';
            choices--;
            backTrack(choices, broad, row + 1);
            choices++;
            broad[row][i] = '.';
        }
    }

    /**
     * 检查 (x, y) 位置上能否放置Q
     *
     * @param broad 棋盘
     * @param x     Q的横坐标
     * @param y     Q的纵坐标
     * @return 该位置是否可以放置Q
     */
    private boolean isValid(char[][] broad, int x, int y) {
        // 检查八个方向是否有效
        for (int i = 0; i < positions.length; i++) {
            int newX = x + positions[i][0];
            int newY = y + positions[i][1];
            while (newX >= 0 && newX < broad.length && newY >= 0 && newY < broad[0].length) {
                if (broad[newX][newY] == 'Q') {
                    return false;
                }
                newX += positions[i][0];
                newY += positions[i][1];
            }
        }

        return true;
    }

    /**
     * 处理执行结果
     *
     * @param broad
     * @return
     */
    private List<String> charArrayToStr(char[][] broad) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < broad.length; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < broad[i].length; j++) {
                res.append(broad[i][j]);
            }
            result.add(res.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }


    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
