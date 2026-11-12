class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = 4;
        int maxScore = -1;
        int[][] dp = new int[n+1][4];
        for (int i=1; i<=n; i++) {
            for(int j=0; j<4; j++) {
                if(j==0) dp[i][j] = land[i-1][j] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
                else if (j==1) dp[i][j] = land[i-1][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
                else if (j==2) dp[i][j] = land[i-1][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
                else dp[i][j] = land[i-1][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            }
        }
        for(int k=0; k<m; k++) {
            maxScore = Math.max(maxScore, dp[n][k]);
        }
        return maxScore;
    }
}