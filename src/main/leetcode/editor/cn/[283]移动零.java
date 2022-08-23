
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
