import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int location = 0;
        int curFuel = startFuel;
        int ans = 0;
        int index = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        while (location < target) {
            if (curFuel == 0) {
                // 从经过的加油站里选择油量最大的进行加油操作
                if (!q.isEmpty() && ++ans >= 0) {
                    curFuel += q.poll();
                } else return -1;
            }
            location += curFuel;
            curFuel = 0;
            while (index < stations.length && stations[index][0] <= location) {
                q.add(stations[index][1]);
                index++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
