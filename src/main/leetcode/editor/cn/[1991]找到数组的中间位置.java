package main.leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    暴力解法
    public int findMiddleIndexFirst(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sum(0, i - 1, nums) == sum(i + 1, nums.length - 1, nums)) {
                return i;
            }
        }
        return -1;
    }
    public int findMiddleIndex(int[] nums) {
        return preSum(nums);
    }

    public int sum(int i, int j, int[] nums) {
        int sum = 0;
        for (int x = 0; x < nums.length; x++) {
            if (x >= i && x <= j) {
                sum += nums[x];
            }
        }
        return sum;
    }

//    前缀和解法

    public int preSum(int[] nums) {
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (presum[i] - nums[i] == presum[nums.length - 1] - presum[i]) {
                return i;
            }
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
