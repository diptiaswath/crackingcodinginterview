package heaps;

//https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solution/

import java.util.Arrays;

public class BruteMinCostToHireKWorkers {

    //For each captain worker that will be paid their minimum wage expectation,
    // let's calculate the cost of hiring K workers where each point of quality
    // is worth wage[captain] / quality[captain] dollars.
    // With this approach, the remaining implementation is straightforward

    //O(N^2 log N)
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int N = quality.length;
        double minCost = 1e9;

        for (int i = 0; i < N; i++) {
            double ratio = (double) wage[i] / quality[i];

            double[] prices = new double[N];

            int t = 0;
            for (int j = 0; j < N; j++) {
                double price = ratio * quality[j];
                if (price < wage[j]) {
                    continue;
                }
                prices[t++] = price;
            }

            if (t < k) {
                continue;
            }
            Arrays.sort(prices, 0, t);
            double workPrice = 0;

            for (int l = 0; l < k; l++) {
                workPrice += prices[l];
            }
            minCost = Math.min(minCost, workPrice);

        }

        System.out.println(minCost);


        return minCost;
    }
}
