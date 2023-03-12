
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

//Definition for a binary tree node.

class Solution {
//    static class TreeNode {
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
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length <= 0) return null;
        int max = Arrays.stream(nums).max().getAsInt();
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(max);
        TreeNode left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        TreeNode right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
