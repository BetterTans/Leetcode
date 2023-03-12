package main.leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

    private Map<String, Boolean> map;

    private Map<Integer, Set<String>> lengthMap;

    public WordDictionary() {
        this.map = new HashMap<String, Boolean>();
        this.lengthMap = new HashMap<>();
    }

    public void addWord(String word) {
        map.put(word, word.contains(".") ? true : false);
        Set<String> orDefault = lengthMap.getOrDefault(word.length(), new HashSet<>());
        orDefault.add(word.toLowerCase());
        lengthMap.put(word.length(), orDefault);
    }

    public boolean search(String word) {
        if (lengthMap.isEmpty() || !lengthMap.containsKey(word.length())){
            return false;
        }
        if (!word.contains(".") && map.containsKey(word)) {
            return true;
        }
        if (!word.contains(".") && !map.containsKey(word)) {
            return false;
        }
        for (String s : lengthMap.get(word.length())) {
            int up = 0;
            int down = 0;

            while (up < s.length() && down < word.length()) {
                char upC = s.charAt(up);
                char downC = word.charAt(down);
                if (Character.toString(downC).equals(".") || Character.toString(upC).equals(Character.toString(downC))) {
                    down++;
                    up++;
                }
                if (!Character.toString(downC).equals(".") && !Character.toString(upC).equals(Character.toString(downC))) {
                    up++;
                }
            }
            if (s.length() == word.length() && up == down) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("m.."));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
