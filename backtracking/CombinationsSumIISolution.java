package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationsSumIISolution {
    private void doCombine(int target, int start, LinkedList<Integer> comb, int[] cands, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < cands.length; i++) {
            if (i > start && cands[i] == cands[i-1]) {
                continue;
            }

            comb.add(cands[i]);
            doCombine(target - cands[i], i + 1, comb, cands, result);
            comb.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        LinkedList<Integer> comb = new LinkedList<Integer>();
        doCombine(target, 0, comb, candidates, result);
        return result;
    }
}
