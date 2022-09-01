
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] difference = new int[n + 1];
        int[] preSums = new int[difference.length + 1];

        for (int[] booking : bookings) {
            difference[booking[0] - 1] += booking[2];
            difference[booking[1]] -= booking[2];
        }
        for (int i = 0; i < difference.length; i++) {
            preSums[i + 1] = preSums[i] + difference[i];
        }

        return Arrays.copyOfRange(preSums, 1, difference.length);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
