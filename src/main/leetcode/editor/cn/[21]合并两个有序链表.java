
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preNode = new ListNode(-1);
        ListNode curOne = list1;
        ListNode curTwo = list2;
        ListNode cur = preNode;

        while (curOne != null && curTwo != null) {
            if (curOne.val <= curTwo.val) {
                cur.next = curOne;
                curOne = curOne.next;
            } else {
                cur.next = curTwo;
                curTwo = curTwo.next;
            }
            cur = cur.next;
        }
        if (curOne != null) {
            cur.next = curOne;
        }
        if (curTwo != null) {
            cur.next = curTwo;
        }
        return preNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
