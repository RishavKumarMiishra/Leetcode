class Solution {
    public int numSpecial(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean found = false;
                if (mat[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (k != j) {
                            if (mat[i][k] == 1) found = true;
                        }
                    }    
                    for (int l = 0; l < m; l++) {
                        if (l != i) {
                            if (mat[l][j] == 1) found = true;
                        }
                    }
                    if (!found) ans++;
                }
            }
        }
        return ans;
    }
}