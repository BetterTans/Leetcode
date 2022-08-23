
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode a, b;
        a = b = head;
        // 这里有两个目的 1：找到每个长为k的链表的节点组 a为开始节点，b为尾节点
        for (int i = 0; i < k; i++) {
            // 递归结束的条件 当不足k个节点的时候 不需要反转
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverseBetween(a, b);
        head.next = reverseKGroup(b, k);
        return newHead;

    }
    public ListNode reverseBetween(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head , next = head;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
