
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[right]) {
                left = mid;
            }
            if (nums[left] < nums[right]) {
                right = mid;
            }
            if (nums[left] == nums[right]) {
                return nums[right];
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
