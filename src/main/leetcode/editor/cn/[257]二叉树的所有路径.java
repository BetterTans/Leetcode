
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
//        System.out.println(res);
        return res;
    }

    public LinkedList<Integer> path = new LinkedList<Integer>();
    public List<String> res = new ArrayList<String>();

    public void traverse(TreeNode node) {
        if (node == null) return;
        path.offerLast(node.val);
        if (node.left == null && node.right == null) {
            StringJoiner joiner = new StringJoiner("->");
            for (Integer integer : path) {
                joiner.add(String.valueOf(integer));
            }
            String collect = joiner.toString();
            res.add(collect);
        }
        traverse(node.left);
        traverse(node.right);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
