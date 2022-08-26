
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        Map<Integer, Integer> map = countMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, obj) -> old, LinkedHashMap::new));
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            k -= entry.getValue();
            if (k < 0) break;
            index++;
        }
        return map.size() - index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
