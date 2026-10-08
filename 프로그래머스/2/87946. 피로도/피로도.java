import java.util.*;
class Solution {
    private static int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}