class Solution {
    public int kthGrammar(int n, int k) {
        int d = 0;
        int rev = 0;
        while (Math.pow(2, d) < k) {
            d++;
        }
        while (d >= 1) {
            int cent = (int)Math.pow(2, d-1);
            if (k > cent) {
                rev++;
                k -= cent;
            }
            d--;
        }

        if (rev%2 == 1) return 1;
        else return 0;
    }
}