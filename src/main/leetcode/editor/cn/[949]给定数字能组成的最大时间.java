package main.leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final Map<Integer, Integer> set = new HashMap();

    public static String largestTimeFromDigits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i != j && k != i && k != j) {
                        int l = 6 - i - j - k;
                        int hh = arr[i] * 10 + arr[j];
                        int ms = arr[k] * 10 + arr[l];
                        if (hh < 24 && ms < 60) {
                            max = Math.max(max, hh * 60 + ms);
                        }
                    }
                }
            }
        }
        return max > Integer.MIN_VALUE ? String.format("%02d:%02d", max / 60, max % 60) : "";
    }

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{2, 0, 6, 6}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
