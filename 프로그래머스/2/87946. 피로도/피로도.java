import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons, new boolean[dungeons.length]);
    }
    
    private int dfs(int k, int[][] dungeons, boolean[] visited) {
        int max = 0;
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                max = Math.max(max, 1 + dfs(k-dungeons[i][1], dungeons, visited));
                visited[i] = false;
            }
        }
        return max;
    }
}