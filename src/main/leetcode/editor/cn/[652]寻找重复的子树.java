package main.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<String, Integer> map = new HashMap<>();

    private LinkedList<TreeNode> results = new LinkedList<>();

    private final String NULL = "#";

    private final String SPLIT = ",";

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return results;
    }

    public String traverse(TreeNode root) {
        if (root == null) {
            return NULL;
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String res = left + SPLIT + right + SPLIT + root.val;
        Integer freq = map.getOrDefault(res, 0);
        if (freq == 1) {
            results.add(root);
        }
        map.put(res, freq + 1);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
