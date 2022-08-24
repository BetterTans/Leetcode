
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        int[] preSums = new int[hours.length + 1];
        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        int res = 0;
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 1; i < preSums.length; i++) {
            if (!index.containsKey(preSums[i])) index.put(preSums[i], i);
            if (preSums[i] > 0) res = Math.max(res, i);
            else if (index.containsKey(preSums[i] - 1)) res = Math.max(res, i - index.get(preSums[i] - 1));
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
