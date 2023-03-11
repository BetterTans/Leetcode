package main.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (result.size() > 0 && result.get(result.size() - 1)[1] >= start ) {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], end);
            } else {
                result.add(new int[]{start, end});
            }
        }
        int[][] ints = new int[result.size()][];
        return result.toArray(ints);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
