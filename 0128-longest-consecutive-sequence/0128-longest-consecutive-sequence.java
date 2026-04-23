class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.getOrDefault(nums[i]-1, 0)+mp.getOrDefault(nums[i]+1, 0) + 1);
                mp.put(nums[i] - mp.getOrDefault(nums[i] - 1, 0), mp.get(nums[i]));
                mp.put(nums[i] + mp.getOrDefault(nums[i] + 1, 0), mp.get(nums[i]));
                max = Math.max(max, mp.get(nums[i]));
            }
        }


        return max;


    }
}