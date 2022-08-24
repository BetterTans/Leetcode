
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] preNums = new int[nums.length + 1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i =  0; i < preNums.length; i++) {
            int mod = preNums[i] % k;
            if (!map.containsKey(mod)) {
                map.put(mod, i);
            }
            if (map.containsKey(mod) && (i - map.get(mod)) >= 2) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
