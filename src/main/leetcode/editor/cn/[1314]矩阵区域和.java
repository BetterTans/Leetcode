import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] preSum = new int[r + 1][c + 1];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] + mat[i][j] - preSum[i][j];
            }
        }

        int[][] ret = new int[mat.length][mat[0].length];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int r1 = i - k;
                int c1 = j - k;
                int r2 = i + k;
                int c2 = j + k;
                if (r1 <= 0) r1 = 0;
                if (c1 <= 0) c1 = 0;
                if (r2 >= r) r2 = r - 1;
                if (c2 >= c) c2 = c - 1;
                ret[i][j] = preSum[r2 + 1][c2 + 1] - preSum[r2 + 1][c1] - preSum[r1][c2 + 1] + preSum[r1][c1];
            }
        }

        return ret;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
