
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;

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

    class Position {
        public int x;
        public int y;
        public int val;

        public Position(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private List<Position> list = new ArrayList<Position>();

    private HashMap<Integer, List<Position>> map = new HashMap<Integer, List<Position>>();

    private List<Integer> listPositions = new ArrayList<Integer>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        traverse(root, 0, 0);
        Collections.sort(listPositions);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer po : listPositions) {
            List<Position> positions = map.get(po);
            Collections.sort(positions, (a, b) -> {
                if (a.x == b.x) {
                    return a.val - b.val;
                }
                if (a.y == b.y) {
                    return a.x - b.x;
                }
                return a.y - b.y;
            });
            List<Integer> collect = positions.stream().map(position -> position.val).collect(Collectors.toList());
            res.add(collect);
        }
        return res;
    }

    private void traverse(TreeNode node, Integer x, Integer y) {
        if (node == null) {
            return;
        }
        if (!listPositions.contains(y)) {
            listPositions.add(y);
        }
        List<Position> orDefault = map.getOrDefault(y, new ArrayList<>());
        orDefault.add(new Position(x, y, node.val));
        map.put(y, orDefault);
        traverse(node.left, x + 1, y - 1);
        traverse(node.right, x + 1, y + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
