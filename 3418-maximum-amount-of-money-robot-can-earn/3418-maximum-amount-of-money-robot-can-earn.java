class Solution {
    Integer[][][] memo;
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        memo = new Integer[n][m][3];
        return findMax(coins, 0, 0, 0);
    }

    public int findMax(int[][] coins, int i, int j, int negUsed) {
        if (i >= coins.length || j >= coins[0].length) return Integer.MIN_VALUE;
        if (i == coins.length -1 && j == coins[0].length-1) {
            if (negUsed < 2 && coins[i][j] < 0) return 0;
            return coins[i][j]; 
        }

        if (memo[i][j][negUsed] != null) return memo[i][j][negUsed];

        int take = coins[i][j] + Math.max(findMax(coins, i+1, j, negUsed), findMax(coins, i, j+1, negUsed));

        int neutralize = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && negUsed < 2) {
            neutralize = Math.max(findMax(coins, i+1, j, negUsed+1), findMax(coins, i, j+1, negUsed+1));
        }
        return memo[i][j][negUsed] = Math.max(take, neutralize);
    }
}