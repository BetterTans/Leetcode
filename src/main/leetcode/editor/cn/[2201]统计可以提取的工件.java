import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Integer, HashSet<Integer>> mSet = new HashMap<Integer, HashSet<Integer>>();

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        for (int i = 0; i < dig.length; i++) {
            HashSet<Integer> set = mSet.getOrDefault(dig[i][0], new HashSet<>());
            set.add(dig[i][1]);
            mSet.put(dig[i][0], set);
        }
        int count = 0;
        // 获取所有工件的位置坐标
        for (int i = 0; i < artifacts.length; i++) {
            int row1 = artifacts[i][0];
            int col1 = artifacts[i][1];
            int row2 = artifacts[i][2];
            int col2 = artifacts[i][3];
            Boolean find = true;
            for (int r = row1; r <= row2; r++) {
                for (int c = col1; c <= col2; c++) {
                    int[] pos = new int[]{r, c};
                    find = find && isDig(pos);
                }
            }
            if (find) {
                count++;
            }
        }
        return count;
    }

    public boolean isDig(int[] pos) {
        if (mSet.getOrDefault(pos[0], new HashSet<>()).contains(pos[1])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.digArtifacts(2, new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 1, 1, 1}
        }, new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
        });
    }
}
//leetcode submit region end(Prohibit modification and deletion)
