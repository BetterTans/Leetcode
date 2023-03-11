
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            if (nums[left] == nums[right]) {
                return nums[right];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findMin(new int[]{2,1});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
