
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        int[] preSums = new int[hours.length + 1];
        preSums[0] = 0;
        HashMap<Integer, Integer> preSumToIndexMap = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (!preSumToIndexMap.containsKey(preSums[i])) preSumToIndexMap.put(preSums[i], i);
            // preSum[i] - preSum[j] > 0 吗  => preSum[i] > preSum[j]  有两种情况
            //          preSum[i] > 0: 那么说明从[0，i - 1) 都是表现良好, 区间长度取Max(res, i)
            if (preSums[i] > 0) {
                res = Math.max(res, i);
            }
            // preSums[i] < 0:
            //          那么 要使得preSums[i] - preSums[j] > 0 则有 preSums[i] > preSums[j] 所以preSums[j] 也是一个负数，
            //          要去找preSums[j] => preSums[i] - 1 ， 此时可以不停的使用preSums[i] - 1探测在map中是否出现过 来寻找j可能的位置
            //
            // preSums[i] < 0时，前面的表现情况就有两种可能
            //          1. 前面每天都是-1，每天都劳累，那么preSums[i] 也是负数
            //               这种情况下，preSums[i] 是负数递减的，
            //               绝对不存在 preSums[j] = preSums[i] - 1 and preSums[i] - 1 < preSums[i] && j < i 的情况出现，
            //               所以也不会可能在map中找到preSums[i] - 1 更不用去接着尝试preSums[i] - 2
            //          2. 前面出现过表现良好的时间，只不过从[0, i - 1) 这个区间里 负数居多 所以preSums[i] 是负数
            //               这种情况下，preSums[i] 是一个先下降后上升的V形函数 对于 preSums[i] - 1  一定会出现，且map记录了出现的第一次的位置j
            //               该位置即为j最小的位置，如果preSums[i] 一直-1 ，那么j的位置会一直往后移动到V字形函数的最小值处，此时 i - j 反而会不断缩小
            //               2情况下，map中一定会有preSums[i] - 1
            // 所以，preSums[i] < 0 时，只要探测一次preSums[i] - 1 的j是否在map中即可得到i - j 的最大值
            else if (preSumToIndexMap.containsKey(preSums[i] - 1)) {res = Math.max(res, i - preSumToIndexMap.get(preSums[i] - 1));}

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
