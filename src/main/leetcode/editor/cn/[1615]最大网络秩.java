import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> roadsMap = new HashMap<>();
        for (int[] road : roads) {
            HashSet<Integer> orDefault = roadsMap.getOrDefault(road[0], new HashSet<>());
            orDefault.add(road[1]);
            roadsMap.put(road[0], orDefault);

            HashSet<Integer> orDefault2 = roadsMap.getOrDefault(road[1], new HashSet<>());
            orDefault2.add(road[0]);
            roadsMap.put(road[1], orDefault2);


        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    HashSet<Integer> iSet = roadsMap.getOrDefault(i, new HashSet<>());
                    HashSet<Integer> jSet = roadsMap.getOrDefault(j, new HashSet<>());
                    int sum = jSet.size() + iSet.size();
                    max = Math.max(iSet.contains(j) && jSet.contains(i) ? sum - 1 : sum, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][]  r = new int[][]{
                new int[]{0, 1},
                new int[]{0, 3},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{2, 4},
        };

        maximalNetworkRank(5, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
