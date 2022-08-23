
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        PriorityQueue<String> q = new PriorityQueue<String>((a, b) -> (b.length() - a.length()));
        for (int i = 0; i < s.length(); i++) {
            q.add(palindrome(s, i, i));
            q.add(palindrome(s, i, i + 1));
        }
        return q.poll();
    }

    // find the longestPalindrome String  in the index from start to end
    public String palindrome(String s, int start, int end) {
        while ( start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
