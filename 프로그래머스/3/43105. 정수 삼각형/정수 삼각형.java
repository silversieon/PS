class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n-1].length;
        int[][] dp = new int[n+1][m];
        int max = -1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                if (j==0) dp[i][j] = triangle[i-1][j] + dp[i-1][j];
                else if (j==i-1) dp[i][j] = triangle[i-1][j] + dp[i-1][j-1];
                else dp[i][j] = triangle[i-1][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        for(int k=0; k<m; k++) {
            max = Math.max(max, dp[n][k]);
        }
        return max;
    }
}