import java.util.*;

class Solution {
    private static int[] dx = {1, 0}, dy = {0, 1};
    private static int max = 0, M, N;
    private static int[][] map;
    private static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n][m];
        dp = new int[n][m];
        M = m;
        N = n;
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        return dfs(0, 0);
    }
    public int dfs(int x, int y){
        if(x==N-1 && y==M-1){
            return 1;
        }
        if(dp[x][y] != 0){
            return dp[x][y]%1000000007;
        }
        for(int i=0; i<2; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && map[nextX][nextY]==0){
                dp[x][y] += dfs(nextX, nextY);
            }
        }
        return dp[x][y]%1000000007;
    }
}