
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private HashSet<Integer> set =  new HashSet<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return findLowestCommonAncestor(root);
    }

    private TreeNode findLowestCommonAncestor(TreeNode root) {
        if (root == null) return null;
        if (set.contains(root.val)) return root;
        TreeNode left = findLowestCommonAncestor(root.left);
        TreeNode right = findLowestCommonAncestor(root.right);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
