
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
    ListNode tailNode = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        // 这里实际上 left 一直减到left为1的时候，reverseBetween(head.next, left - 1, right - 1) 返回的结果就是以节点left为起点反转前right - left + 1个的结果
        // 此时外层函数的head实际上是原来的left的节点的前一个节点 head.next指向函数的返回值就是链接反转后的链表
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tailNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tailNode;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
