
class Solution {
    int[] f2, f3, f5;
    int t2, t3, t5;
    int n;
    int[] memo;

    public int countSequences(int[] nums, long k) {
        n = nums.length;
        
        long temp = k;
        t2 = 0; t3 = 0; t5 = 0;
        while (temp % 2 == 0) { t2++; temp /= 2; }
        while (temp % 3 == 0) { t3++; temp /= 3; }
        while (temp % 5 == 0) { t5++; temp /= 5; }
        
        if (temp != 1) return 0;
        
        if (Math.abs(t2) > 38 || Math.abs(t3) > 19 || Math.abs(t5) > 19) return 0;

        f2 = new int[n];
        f3 = new int[n];
        f5 = new int[n];
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (v % 2 == 0) { f2[i]++; v /= 2; }
            while (v % 3 == 0) { f3[i]++; v /= 3; }
            while (v % 5 == 0) { f5[i]++; v /= 5; }
        }

        memo = new int[n * 77 * 39 * 39];
        Arrays.fill(memo, -1);

        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int p2, int p3, int p5) {
        if (i == n) {
            return (p2 == t2 && p3 == t3 && p5 == t5) ? 1 : 0;
        }

        int p2Off = p2 + 38;
        int p3Off = p3 + 19;
        int p5Off = p5 + 19;

        int hash = (((i * 77) + p2Off) * 39 + p3Off) * 39 + p5Off;

        if (memo[hash] != -1) return memo[hash];

        int ways = 0;
        ways += dfs(i + 1, p2 + f2[i], p3 + f3[i], p5 + f5[i]);
        ways += dfs(i + 1, p2 - f2[i], p3 - f3[i], p5 - f5[i]);
        ways += dfs(i + 1, p2, p3, p5);

        return memo[hash] = ways;
    }
}