package main.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            right++;
            while (sum >= target && left < right) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min ==  Integer.MAX_VALUE ? 0 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
