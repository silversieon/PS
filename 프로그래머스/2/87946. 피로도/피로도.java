import java.util.*;
class Solution {
    private static int answer;
    private static boolean[] visited;
    public void dfs(int k, int[][] dungeons, int depth){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
}