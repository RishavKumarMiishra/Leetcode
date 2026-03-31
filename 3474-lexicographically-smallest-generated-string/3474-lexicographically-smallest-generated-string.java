class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;
        char[] ans = new char[len];
        
        // Initialize the array with a placeholder
        for (int i = 0; i < len; i++) {
            ans[i] = '*';
        }
        
        // Step 1: Apply all 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    // If a character is already set by a previous 'T' and conflicts, it's impossible
                    if (ans[i + j] != '*' && ans[i + j] != str2.charAt(j)) {
                        return ""; 
                    }
                    ans[i + j] = str2.charAt(j);
                }
            }
        }
        
        // Step 2: Ensure 'T' placements didn't accidentally violate an 'F' constraint
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return ""; 
                }
            }
        }
        
        // Step 3: Fill '*' with the lexicographically smallest valid character
        for (int i = 0; i < len; i++) {
            if (ans[i] == '*') {
                // Try 'a' through 'z'
                for (char c = 'a'; c <= 'z'; c++) {
                    ans[i] = c;
                    boolean valid = true;
                    
                    // Check if this character violates any 'F' constraint that OVERLAPS with index i
                    int start = Math.max(0, i - m + 1);
                    int end = Math.min(n - 1, i);
                    
                    for (int k = start; k <= end; k++) {
                        if (str1.charAt(k) == 'F') {
                            boolean match = true;
                            for (int j = 0; j < m; j++) {
                                if (ans[k + j] != str2.charAt(j)) {
                                    match = false;
                                    break;
                                }
                            }
                            if (match) {
                                valid = false;
                                break;
                            }
                        }
                    }
                    
                    // If no overlaps violate an 'F', we found our smallest valid character
                    if (valid) {
                        break; 
                    }
                }
            }
        }
        
        return new String(ans);
    }
}