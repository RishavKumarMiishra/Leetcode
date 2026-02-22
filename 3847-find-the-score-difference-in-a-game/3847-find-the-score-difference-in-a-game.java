class Solution {
    public int scoreDifference(int[] nums) {
        boolean a = true;
        boolean b = false;
        int scorea = 0;
        int scoreb = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 1) {
                boolean temp = a;
                a = b;
                b = temp;
            }
            if ((i+1)%6 == 0) {
                boolean temp = a;
                a = b;
                b = temp;                
            }
            if (a) {
                scorea+=nums[i];
            } else {
                scoreb+=nums[i];
            }
        }

        return scorea-scoreb;
    }
}