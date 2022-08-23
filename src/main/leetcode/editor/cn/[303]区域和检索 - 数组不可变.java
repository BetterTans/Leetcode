
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] preNums = null;

    public NumArray(int[] nums) {
        preNums = new int[nums.length + 1];
        preNums[0] = 0;
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
