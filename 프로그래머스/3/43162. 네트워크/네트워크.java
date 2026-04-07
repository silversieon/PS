import java.util.*;
class Solution {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static void dfs(int node){
        visited[node] = true;
        for(int i=0; i<graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);
            if(!visited[i] && next==1) dfs(i);
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph.get(i).add(computers[i][j]);
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}