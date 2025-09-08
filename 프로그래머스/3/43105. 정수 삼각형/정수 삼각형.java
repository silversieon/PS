class Solution {
    static int[][] tri, dp;
    static int height = 0, max = 0;
    public int solution(int[][] triangle) {
        tri = triangle;
        height = triangle.length;
        dp = new int[height+1][height];
        for(int i=1; i<=height; i++){
            for(int j=0; j<i; j++){
                if(j==0){
                    dp[i][j] = tri[i-1][j] + dp[i-1][j];
                } else if(j==i-1){
                    dp[i][j] = tri[i-1][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = tri[i-1][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        for(int j=0; j<height; j++){
            max = Math.max(max, dp[height][j]);
        }
        return max;
    }
}