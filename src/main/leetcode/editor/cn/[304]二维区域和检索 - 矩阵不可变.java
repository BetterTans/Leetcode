
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] preNums = null;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return;
        preNums = new int[m + 1][n + 1];
        // 前缀和 从1开始 区间[1, length of matrix]
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                preNums[i][j] = preNums[i - 1][j] + preNums[i][j - 1]  - preNums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNums[row2 + 1][col2 + 1] - preNums[row1][col2 + 1] - preNums[row2 + 1][col1] + preNums[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
