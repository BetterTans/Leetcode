
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        this.preSum = new int[rLen + 1][cLen + 1];
        preSum[0][0] = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] + matrix[i][j] - preSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] mar = new int[][]{
                new int[]{0, 1, 4, 2},
                new int[]{6, 3, 2, 1},
                new int[]{2, 0, 1, 5},
                new int[]{1, 0, 1, 7},
                new int[]{0, 3, 0, 5},
        };
        NumMatrix numMatrix = new NumMatrix(mar);

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
