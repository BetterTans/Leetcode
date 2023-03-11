package main.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            }
            if (num != 1) {
                count = 0;
            }
        }
        return findMaxConsecutiveOnes(nums,-1);
//        return max;
    }

    public int findMaxConsecutiveOnes(int[] nums, int next) {
        int zeroPosition = 0-1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                zeroPosition = i;
            }
            max = Math.max(max, i - zeroPosition);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
