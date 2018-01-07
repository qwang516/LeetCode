package wangqi.dynamicprogramming;

/*
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the
 * maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and
 * wt[0..n-1] which represent values and weights associated with n items respectively. Also given an
 * integer W which represents knapsack capacity, find out the maximum value subset of val[] such
 * that sum of the weights of this subset is smaller than or equal to W. You cannot break an item,
 * either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapsackProblemSolution {
    public int brutalForce(int[] wt, int[] val, int W) {
        int size = wt.length;
        return search(0, wt, val, size, 0, W);
    }

    /**
     * @param i start of searching
     * @param curWeight current weight of the knapsack
     * @param totalWeight maximum weight of the knapsack
     * @return maximum value
     */
    private int search(int i, int[] wt, int[] val, int size, int curWeight, int totalWeight) {
        // no more items to search
        if (i >= size) {
            return 0;
        }
        // if it cant hold the current item, move to the next one
        if (curWeight + wt[i] > totalWeight) {
            return search(i + 1, wt, val, size, curWeight, totalWeight);
        }
        // return the maximum of picking the current one and the not picking
        return Math.max(search(i + 1, wt, val, size, curWeight + wt[i], totalWeight) + curWeight,
                search(i + 1, wt, val, size, curWeight, totalWeight));
    }

    public int dynamicProgranmming(int[] wt, int[] val, int W) {
        int size = wt.length;
        int[][] dp = new int[size + 1][W + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < W; j++) {
                if (j < wt[i]) {
                    dp[i + 1][j] = dp[i][j];

                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - wt[i]] + val[i]);
                }

            }
        }
        return dp[size][W];
    }

}
