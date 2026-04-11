class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            m.putIfAbsent(num, new ArrayList<>());
            m.get(num).add(i);
        };
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> e: m.entrySet()) {
            if (e.getValue().size() >= 3) {
                List<Integer> l = e.getValue();
                for (int i = 0; i <= l.size()-3; i++) {
                    int a = l.get(i);
                    int b = l.get(i+1);
                    int c = l.get(i+2);
                    ans = Math.min(ans, Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}