class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        // dp[row][col][negUsed]
        int[][][] dp = new int[n][m][3];
        int INF = (int)1e9;

        // Fill from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int k = 0; k < 3; k++) {
                    
                    // BASE CASE: Bottom-Right cell
                    if (i == n - 1 && j == m - 1) {
                        int current = coins[i][j];
                        int takeAsIs = current;
                        int neutralize = (current < 0 && k < 2) ? 0 : -INF;
                        dp[i][j][k] = Math.max(takeAsIs, neutralize);
                        continue;
                    }

                    // 1. Calculate best path coming from Right or Down
                    int nextBest = -INF;
                    if (i + 1 < n) nextBest = Math.max(nextBest, dp[i + 1][j][k]);
                    if (j + 1 < m) nextBest = Math.max(nextBest, dp[i][j + 1][k]);

                    // Option A: Take the coin normally
                    int res = coins[i][j] + nextBest;

                    // Option B: Neutralize (if negative and have powers left)
                    if (coins[i][j] < 0 && k < 2) {
                        int nextBestWithPowerUsed = -INF;
                        if (i + 1 < n) nextBestWithPowerUsed = Math.max(nextBestWithPowerUsed, dp[i + 1][j][k + 1]);
                        if (j + 1 < m) nextBestWithPowerUsed = Math.max(nextBestWithPowerUsed, dp[i][j + 1][k + 1]);
                        
                        res = Math.max(res, 0 + nextBestWithPowerUsed);
                    }
                    
                    dp[i][j][k] = res;
                }
            }
        }

        return dp[0][0][0];
    }
}