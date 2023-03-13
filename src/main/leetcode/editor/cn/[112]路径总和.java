package main.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

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
class Solution {
    int sum = 0;
    Set<Integer> set = new HashSet<Integer>();
    public boolean hasPathSum(TreeNode root, int target) {
        traverse(root);
        return set.contains(target);
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            set.add(sum);
        }
        traverse(root.left);
        traverse(root.right);
        sum -= root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
