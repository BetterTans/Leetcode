
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
class Solution {
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
    public int sumNumbers(TreeNode root) {
        traverse(root);
        return sum;
    }
    StringBuilder sb = new StringBuilder();
    int sum = 0;
    public void traverse(TreeNode root) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        traverse(root.left);
        traverse(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
