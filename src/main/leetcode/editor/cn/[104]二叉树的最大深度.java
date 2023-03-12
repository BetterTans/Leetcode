
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    private int depth = 0;
    private int res = 0;

    public int maxDepth(TreeNode root) {
//        traverse(root);

        return thrMaxDepth(root);
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        res = Math.max(depth, res);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    int thrMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        res = Math.max(leftDepth, rightDepth);
        return res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
