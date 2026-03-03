class Solution {
    public char findKthBit(int n, int k) {
        
        StringBuilder[] SnArray = new StringBuilder[n+1];
        StringBuilder Sn = makeSi(n, SnArray);
        return Sn.charAt(k-1);
    }

    private StringBuilder reverseInvert(StringBuilder sb) {
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') sb.setCharAt(i, '0');
            else sb.setCharAt(i, '1');
        }

        return sb.reverse();
    }

    private StringBuilder makeSi(int n, StringBuilder[] arr) {
        if (n == 1) {
            StringBuilder s = new StringBuilder("0");
            return s;
        }
        if (arr[n] != null) return arr[n];
        StringBuilder sb = new StringBuilder();
        
        sb.append(makeSi(n-1, arr));
        sb.append("1");
        sb.append(reverseInvert(makeSi(n-1, arr)));
        arr[n] = sb;
        return arr[n];
    }
}