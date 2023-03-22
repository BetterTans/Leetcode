
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyStart = new ListNode(-1);
        ListNode p = dummyStart;
        ListNode dummyEnd = new ListNode(-1);
        ListNode q = dummyEnd;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
//            断开节点
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        p.next = dummyEnd.next;
        return dummyStart.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
