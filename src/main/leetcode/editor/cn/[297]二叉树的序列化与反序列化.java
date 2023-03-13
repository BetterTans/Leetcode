
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String SPLIT = ",";
    private static final String NULL_VALUE = "#";

    private StringBuffer res = new StringBuffer();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        traverse(root);
        return res.toString();
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            res.append(NULL_VALUE).append(SPLIT);
            return;
        }
        res.append(node.val).append(SPLIT);
        traverse(node.left);
        traverse(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(SPLIT);
        LinkedList<String> nodes = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            nodes.add(split[i]);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String s = nodes.removeFirst();
        if (s.equals(NULL_VALUE)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
