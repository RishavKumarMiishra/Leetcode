class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = mat[i][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int a = 0; a < k%m; a++) {
            int[] cur = mat[i].clone();
            if (i%2 == 0) {
                int first = cur[0];
                for (int j = 0; j < m-1; j++) {
                    cur[j] = cur[j+1];
                }
                cur[m-1] = first;
            } else {
                int first = cur[m-1];
                for (int j = m-1; j > 0; j--) {
                    cur[j] = cur[j-1];
                }
                cur[0] = first;                 
            }
            mat[i] = cur; 
        }}

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] != mat[i][j]) return false;
            }
        }

        return true;
    }
}