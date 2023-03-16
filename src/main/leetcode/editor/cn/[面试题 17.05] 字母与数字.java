import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findLongestSubarray(String[] array) {
        int[] preSum = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            preSum[i + 1] = preSum[i] + ("1234567890".indexOf(array[i].charAt(0)) >= 0 ? 1 : -1);
        }

        HashMap<Integer, String[]> sizeMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if ( i + 1 - j < max) {
                    continue;
                }
                if (preSum[i + 1] - preSum[j] == 0) {
                    String[] res = Arrays.copyOfRange(array, j, i + 1);
                    if (!sizeMap.containsKey(res.length)) {
                        sizeMap.put(res.length, res);
                        max = Math.max(max, res.length);
                    }
                }
            }
        }
        return sizeMap.getOrDefault(max, new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findLongestSubarray(new String[]{
                ""
        });
    }
}
//leetcode submit region end(Prohibit modification and deletion)
