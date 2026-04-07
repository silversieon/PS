import java.util.*;
class Solution {
    int n;
    boolean[] visited;
    int[][] computers;
    
    void dfs(int node){
        visited[node] = true;
        for(int i=0; i<n; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}