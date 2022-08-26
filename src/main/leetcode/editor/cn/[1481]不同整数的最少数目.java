
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Map<Integer, Integer> m = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, b) -> old, LinkedHashMap::new));
        int index = 0;
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            k -= entry.getValue();
            if (k < 0) break;
            i++;
        }
        return m.size() - i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
