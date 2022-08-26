
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preMult = new int[nums.length + 1];
        preMult[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            preMult[i + 1] = preMult[i] * nums[i];
        }
        int[] latMult = new int[nums.length + 1];
        latMult[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            latMult[i] = latMult[i + 1] * nums[i];
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            answer[i] = preMult[i] * latMult[i + 1];
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
