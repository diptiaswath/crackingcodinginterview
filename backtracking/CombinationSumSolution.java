package backtracking;

import java.util.*;
;
//https://leetcode.com/problems/combination-sum/
class CombinationSumSolution {
    private static final double THRESHOLD = 0.01;


    public List<List<Double>> combination(double[] a, double target) {
        List<List<Double>> result = new ArrayList<>();
        List<Double> comb = null;
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            comb = new ArrayList<Double>();
            sum = a[i];
            comb.add(a[i]);
            if (Math.abs(sum-target) < THRESHOLD) {
                result.add(comb);
                break;
            }
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                System.out.println("here :" + sum);
                comb.add(a[j]);

                if (Math.abs(sum-target) < THRESHOLD) {
                    result.add(comb);
                    break;
                }
            }
        }
        return result;
    }


    private void backTrack(double remain,
                           LinkedList<Double> comb,
                           int start,
                           double[] a,
                           List<List<Double>> results) {

        if (remain == 0) {
            results.add(new ArrayList<Double>(comb));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < a.length; i++) {
            comb.add(a[i]);
            backTrack(remain - a[i], comb, i, a, results);
            comb.removeLast();
        }
        return;
    }


    public List<List<Double>> recursiveCombine(double target, double[] a) {
        List<List<Double>> results = new ArrayList<List<Double>>();
        LinkedList<Double> comb = new LinkedList<Double>();
        backTrack(target, comb, 0, a, results);
        return results;
    }

    public static void main(String[] args) {
        double[] a = {2.15, 5.0, 4.30};
        double target = 4.30;
        CombinationSumSolution s = new CombinationSumSolution();

        // iterative
        System.out.println(s.combination(a, target));

        // recursive
        System.out.println(s.recursiveCombine(target, a));
    }
}
