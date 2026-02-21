class Solution {
    public int almostPalindromic(String s) {
        int ans = 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int l = j-i+1;
                if (l >= 2 && solve(i, j, dp, s) <= 1) {
                    ans = Math.max(ans, l);
                }
            }
        }

        return ans;
    }

    public int solve(int l, int r, int[][] dp, String s) {
        if (l >= r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = solve(l+1, r-1, dp, s);
        } else {
            return dp[l][r] = 1+Math.min(solve(l+1, r, dp, s), solve(l, r-1, dp, s));
        }
    }
}