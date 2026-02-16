class Solution {
    public int tribonacci(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        if (n == 0) return n0;
        else if (n == 1) return n1;
        else if (n == 2) return n2;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        return arr[n];
    }


}