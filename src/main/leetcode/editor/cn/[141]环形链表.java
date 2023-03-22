
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast == null || fast.next== null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
