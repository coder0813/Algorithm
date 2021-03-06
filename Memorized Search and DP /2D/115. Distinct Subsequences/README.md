## DP
1. Last step and status
	1. B[m-1] == A[n-1] 
	2. B[m-1] and A[n-1] is not a pair, calculate how many times B[0,n-1] appears in A[0,m-2]
	3. dp[i][j], the times of B[0,j-1] appears in A[0,i-1]

2. Transfer function
	* dp[i][j] = dp[i-1][j-1] | A[i-1] = B[j-1] + dp[i-1][j]

3. Initial and boundary conditions
	* If b is empty, B appears 1 time in A, dp[i][0] = 1
	* If a is empty, A appears 0 time in B, dp[0][j] = 0

4. Calculation order
	* 0 to n and 0 to m
	* return dp[m][n]

	
```java
class Solution {
    public int numDistinct(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= m ; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if (j > 0 && a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
```