
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(root.val);
        int size = index - inStart;
        root.left = build(preorder, inorder, preStart + 1, preStart + size, inStart, index - 1);
        root.right = build(preorder, inorder, preStart + size + 1, preEnd, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
