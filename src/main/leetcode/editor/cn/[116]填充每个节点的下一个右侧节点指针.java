import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node startNode = queue.poll();
            if (startNode.left != null) {
                queue.offer(startNode.left);
            }
            if (startNode.right != null) {
                queue.offer(startNode.right);
            }
            for (int i = 1; i < levelSize; i++) {
                Node curNode = queue.poll();
                startNode.next = curNode;
                startNode = curNode;
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
