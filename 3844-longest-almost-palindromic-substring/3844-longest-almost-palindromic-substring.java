class Solution {
    public int almostPalindromic(String s) {
        int ans = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
           ans = Math.max(ans,Math.max(solve(i, i, s, 0), solve(i, i+1, s, 0)));
        }

        return ans;
    }

    public int solve(int l, int r, String s, int skip) {
        if (r >= s.length() && l < 0) {
            return 0;
        }
        if (r >= s.length() || l < 0) {
            return skip == 0 ? 1: 0;
        }

        if (s.charAt(l) == s.charAt(r)) {
            return l==r ? 1+solve(l-1, r+1, s, skip) : 2+solve(l-1, r+1, s, skip);
        } else {
            return skip == 0 ? 1+Math.max(solve(l-1, r, s, 1), solve(l, r+1, s, 1)) : 0;
        }
    }
}