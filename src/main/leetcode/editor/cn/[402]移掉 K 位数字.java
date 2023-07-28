package main.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.removeLast();
        }
        String res = stack.stream().map(i -> String.valueOf(i)).collect(Collectors.joining());
        return res.length() == 0 ? "0" : new StringBuilder(res).reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("10200", 1));
        System.out.println(solution.removeKdigits("9", 1));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
