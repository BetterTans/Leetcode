
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List nums = new ArrayList();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return isPalindrome(nums);
    }

    public boolean isPalindrome(List<Integer> nums) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) != nums.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
