class Solution {
    static int counter = 0;
    static String ans = "";
    public String getHappyString(int n, int k) {
        int total = 3*(int)Math.pow(2, n-1);
        ans = "";
        counter = k;
        if (k>total) return new String();
        makeString(n, new StringBuilder());
        return ans;
    }

    public void makeString(int n, StringBuilder sb) {
        if (sb.length() == n) {
            counter--;
            if (counter == 0) {
                ans = sb.toString();
            }
            return;
        }
        char[] c = new char[]{'a', 'b', 'c'};
        for (char x: c) {
            if (sb.isEmpty() || x != sb.charAt(sb.length()-1)) {
                sb.append(x);
                makeString(n, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}