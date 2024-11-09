// https://leetcode.com/problems/permutations-ii/
class PermuteNumsWithDuplicates {
    private HashMap<Integer, Integer> map = new HashMap<>();

    private void permuteWBacktrack(List<Integer> path, int[] nums, List<List<Integer>> results) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();

            // if the # of occurences of num is 0, it means we have exhausted all permutations of it, so skip
            if (count == 0) {
                continue;
            }

            path.add(num);
            map.put(num, count - 1);

            permuteWBacktrack(path, nums, results);

            path.remove(path.size() - 1);
            map.put(num, count);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        }
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        permuteWBacktrack(new ArrayList<Integer>(), nums, results);
        return results;
    }
}