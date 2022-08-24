
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preNums = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        preNums[0] = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
            count += map.getOrDefault(preNums[i] - k, 0);
            // 当前和
            map.put(preNums[i], map.getOrDefault(preNums[i], 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
