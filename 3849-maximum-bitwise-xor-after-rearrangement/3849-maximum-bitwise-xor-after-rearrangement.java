class Solution {
    public String maximumXor(String s, String t) {
        int n = s.length();
        int[] count = new int[2];
        for (char c: t.toCharArray()) {
            count[c-'0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ;i++) {
            if (s.charAt(i) == '0' && count[1] > 0) {
                sb.append(1);
                count[1]--;
            } else if (s.charAt(i) == '1' && count[0] > 0) {
                sb.append(1);
                count[0]--;
            } else sb.append(0);
        }

        return sb.toString();
    }
}