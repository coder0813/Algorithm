class Solution {
    public boolean isMatch(String s, String p) {  
        return helper(s, p, 0, 0);  
    }  
      
    public boolean helper(String s, String p, int i, int j){  
        if( j == p.length()) return i == s.length();  

        if( p.charAt(j) != '*'){  
            if( i >= s.length() || ( s.charAt(i) != p.charAt(j) && p.charAt(j) != '?'))  return false;  
            else return helper(s, p, i + 1, j + 1);  
        }  
        else{  
            while( i < s.length() ){  
                if(helper(s, p, i, j + 1))  return true;  
                i++;  
            }  
        }  
        return helper(s, p, i, j + 1);  
    }  
}

class Solution {
    public boolean isMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j==0) {
                    dp[i][j] = (i == 0);
                    continue;
                }
                dp[i][j] = false;
                if (b.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1];
                    if (i > 0) {
                        dp[i][j] |= dp[i-1][j];
                    }
                } else {
                    if (i > 0) {
                        if (a.charAt(i-1) == b.charAt(j-1) || b.charAt(j-1) == '?') {
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}