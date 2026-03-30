class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] efeq = new int[26];
        int[] ofeq = new int[26];

        for (int i = 0; i < n; i++) {
            int f = s1.charAt(i);
            int s = s2.charAt(i);
            if (i%2 == 0) {
                efeq[f-'a']++;
                efeq[s-'a']--;
            } else {
                ofeq[f-'a']++;
                ofeq[s-'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (ofeq[i] != 0 || efeq[i] != 0) return false;
        }

        return true;
    }
}