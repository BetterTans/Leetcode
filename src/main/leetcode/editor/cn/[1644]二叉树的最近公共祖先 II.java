
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    private Boolean isP = false;

    private Boolean isQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lowestCommonAncestor = findLowestCommonAncestor(root, p, q);
        if (isP && isQ) {
            return lowestCommonAncestor;
        }
        return null;
    }

    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = findLowestCommonAncestor(root.left, p, q);
        TreeNode right = findLowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) isP = true;
            if (root.val == q.val) isQ = true;
            return root;
        }
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
