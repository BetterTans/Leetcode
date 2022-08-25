
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 题意：https://leetcode.cn/problems/matrix-block-sum/solution/you-qian-ru-shen-bao-li-xing-lie-qian-zh-5503/
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res = new int[mat.length][mat[0].length];
        PreSumMartix preSumMartix = new PreSumMartix(mat);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                int x1 = Math.max(i - k, 0);
                int y1 = Math.max(j - k, 0);

                int x2 = Math.min(i + k, res.length - 1);
                int y2 = Math.min(j + k, res[0].length - 1);

                res[i][j] = preSumMartix.getArray(x1, y1, x2, y2);
            }
        }
        return res;
    }

    class PreSumMartix {
        int[][] preSum = null;
        public PreSumMartix(int[][] Mat) {
            this.preSum = new int[Mat.length + 1][Mat[0].length + 1];
            for (int i = 0; i < Mat.length; i++) {
                for (int j = 0; j < Mat[0].length; j++) {
                    preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + Mat[i][j];
                }
            }
        }
        public int getArray(int x1, int y1, int x2, int y2) {
            return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
