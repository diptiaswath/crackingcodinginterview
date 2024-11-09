
// https://leetcode.com/problems/combination-sum-iii/description/

//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations.
//The list must not contain the same combination twice, and the combinations may be returned in any order.
class CombinationsSumIIISolution {

    protected void backtrack(
            int remain,
            int k,
            LinkedList<Integer> comb,
            int start,
            List<List<Integer>> results
    ) {
        if (remain == 0 && comb.size() == k) {
            // Note: it's important to make a deep copy here,
            // Otherwise the combination would be reverted in other branch of backtracking.
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0 || comb.size() == k) {
            return;
        }

        // Iterate through the reduced list of candidates.
        for (int i = start; i < 9; ++i) {
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(n, k, comb, 0, results);
        return results;
    }

}