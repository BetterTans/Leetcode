import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        List<String> words = new ArrayList<>();
        for (String str : s.split(" ")) {
            words.add(reverseStr(str));
        }
        return words.stream().collect(Collectors.joining(" "));
    }

    public String reverseStr(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
