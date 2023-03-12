
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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxD(root);
        return max;
    }

    private int maxD(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxD(root.left);
        int rightMax = maxD(root.right);
        max = Math.max(max, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
