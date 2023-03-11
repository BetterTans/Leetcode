package main.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numFriendRequests(int[] ages) {
        HashMap<Integer, List<Integer>> hasSent = new HashMap<>();
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> orDefault = hasSent.getOrDefault(i, new ArrayList<>());
                if (isFriend(ages[i], ages[j]) ) {
                    orDefault.add(j);
                    hasSent.put(i, orDefault);
                }
            }
        }

        return (int) hasSent.entrySet().stream().map(entry -> entry.getValue().size()).count();
    }

    public boolean isFriend(int myAge, int age) {
        return !(age <= 0.5 * myAge + 7 || age > myAge || age > 100 && myAge < 100);
    }

    public boolean isSent(HashMap<Integer, List<Integer>> hasSent, int me, int friend) {
        return hasSent.getOrDefault(friend, new ArrayList<>()).stream().filter(a -> a == me).count() > 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
