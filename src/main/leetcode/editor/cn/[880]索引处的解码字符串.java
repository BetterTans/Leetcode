
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static String decodeAtIndex(String s, int k) {
        long size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                size *= (s.charAt(i) - '0');
            }
            if (Character.isLetter(s.charAt(i))) {
                size++;
            }
        }
        for (int i = s.length() - 1; i >= 0 ; i--) {
            k %= size;
            if (k == 0 && Character.isLetter(s.charAt(i))) {
                return String.valueOf(s.charAt(i));
            }
            if (Character.isDigit(s.charAt(i))) {
                size /= (s.charAt(i) - '0');
            } else {
                size--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        decodeAtIndex("a2345678999999999999999", 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
