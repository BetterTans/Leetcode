
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {
        int[] preSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSums[i + 1] = nums[i] + preSums[i];
        }
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int left = preSums[i];
            int right = preSums[nums.length] - preSums[i + 1];
            if (left == right) {
                res = i;
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
