class Solution {
    public boolean isDigitorialPermutation(int n) {
        boolean ans = false;
        int[] dp = new int[10];
        Arrays.fill(dp, -1);
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        int div = 10;
        while (n > 0) {
            int rem = n%div;
            int divident = n/10;
            m.put(rem, m.getOrDefault(rem, 0)+1);
            if (dp[rem] == -1) {
                dp[rem] = findFact(rem);
                System.out.println(dp[rem]);
            }

            sum += dp[rem];
            n = divident;
        }
        return find(m, 1, sum, 0);
    }

    public int findFact(int n) {
        if (n == 0 || n == 1) return 1;
        return n*findFact(n-1);
    }

    public boolean find(Map<Integer, Integer> m, int pos, int sum, int form) {
        if (m.isEmpty()) {
            return sum == form;
        }
        boolean ans = false;
        for (Map.Entry<Integer, Integer> entry: m.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
                var newMap = new HashMap<Integer, Integer>(m);
                if (newMap.get(key) == 1) newMap.remove(key);
                else newMap.put(key, value-1);
                if (newMap.isEmpty() && key == 0) {}
                else {
                                    ans = ans || find(newMap, pos*10, sum, form+(key*pos));
                if (ans) return ans;  
                }
            
        }

        return ans;
    }
}