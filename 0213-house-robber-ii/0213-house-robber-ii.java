class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n ==1) return nums[0];
        int prev = nums[0];
        int prev2 = 0;
        
        for (int i = 1; i < n-1; i++) {
            int take = nums[i];
            take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        int prevf = nums[1];
        int prevf2 = 0;
        for (int i = 2; i < n; i++) {
            int take = nums[i];
            take += prevf2;
            int notTake = prevf;
            int curr = Math.max(take, notTake);
            prevf2 = prevf;
            prevf = curr;
        }

        return Math.max(prevf, prev);
    }
}