class Solution {
    ListNode newHead = null;
    public ListNode reverseListNode(ListNode head, int n) {
        if(n == 1) {
            /**
             * n 等于1的时候 head 其实是第k 个节点
             * 因为要在后面把第一个节点的next节点接到第k + 1 个节点上
             * 所以记录一下第k + 1个节点
             */
            newHead = head.next;
            return head;
        }
        // 要反转前k个 那么就要先反转前k - 1 个
        ListNode last = reverseListNode(head.next, n - 1);
        head.next.next = head;
        head.next = newHead;
        return  last;
    }
}