//https://leetcode.com/problems/group-anagrams/editorial/
class GroupAnagrams {

    // O(N. K LOGK) - iterate throyugh n strings. each string is of length k and will be sorted in k log k time
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String key = String.valueOf(sArr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}