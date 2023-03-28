package main.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }
        return preSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
