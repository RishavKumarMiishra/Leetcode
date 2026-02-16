class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] arr = new int[n];
        if (s.charAt(0) != '0') {
            arr[0] = 1;
        } else return 0;

        for (int i = 1; i < n; i++) {
            int comb = Integer.parseInt(s.substring(i-1, i+1));
            if (s.charAt(i-1) == '0') {
                if (comb == 0) return 0;
                arr[i] = arr[i-1];
            }
            else if (0 < comb && comb <= 26) {
                if (s.charAt(i) == '0') {
                    if (i == 1) arr[i] = 1;
                    else arr[i] = arr[i-2];
                } else {
                    if (i == 1) arr[i] = 2;
                    else arr[i] = arr[i-1]+arr[i-2];
                }
            } else {
                if (s.charAt(i) == '0') { 
                    return 0;
                } else {
                    arr[i] = arr[i-1];
                } 
            }
        }

        return arr[n-1];
    }
}