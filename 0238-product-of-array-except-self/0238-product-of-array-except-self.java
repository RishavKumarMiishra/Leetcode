class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] p = new int[len];
        int[] s = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = i == 0 ? 1 : p[i-1]*nums[i-1];
        }
        for (int i = len-1; i >= 0; i--) {
            s[i] = i == len-1 ? 1 : s[i+1]*nums[i+1];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.println(s[i]);
            ans[i] = p[i]*s[i];
        }
        return ans;
    }
}