
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
//          use the priorityQueue<ListNode> priorityQueue to sort the first value in the list
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));
//          put the first value of list in the priorityQueue<ListNode> priorityQueue to get the order of the first values
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
//          get the node from the priority queue
            ListNode node = priorityQueue.poll();
            cur.next = node;
//          when the next node is not empty then put it in the priority queue<ListNode>
            if (node.next != null) {
//          the priority queue will sort the values by priority order
                priorityQueue.add(node.next);
            }
            cur = cur.next;
        }
        return head.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
