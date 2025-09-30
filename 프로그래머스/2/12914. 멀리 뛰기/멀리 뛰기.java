class Solution {
    public long solution(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        if(n>=2){
            dp[1] = 2;
            for(int i=2; i<n; i++){
                dp[i] = (dp[i-1] + dp[i-2])%1234567;
            }
        }
        return dp[n-1]%1234567;
    }
}