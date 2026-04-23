class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2001];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return countSum(n-1,0,  target, nums, dp);
    }

    public int countSum(int ind,int sum, int target, int[] nums, int[][] dp) {

        if (ind < 0) {
            return sum==target ? 1: 0;
        }

        if (dp[ind][sum+1000] != Integer.MIN_VALUE) {
            return dp[ind][sum+1000];
        }

        int plus = countSum(ind-1,sum+nums[ind], target, nums, dp);
        int minus = countSum(ind-1, sum-nums[ind], target, nums, dp);

        return dp[ind][sum+1000]=plus+minus;
    }
}