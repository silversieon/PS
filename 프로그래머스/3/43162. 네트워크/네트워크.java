import java.util.*;
class Solution {
    static int N, answer = 0, connectCount = 0;
    static boolean[][] visited;
    static HashSet<Integer> hs = new HashSet<>();
    static void dfs(int i, int[][] computers){
        for(int j=0; j<N; j++){
            if(i==j) continue;
            if(!visited[i][j] && computers[i][j]==1){
                hs.add(i);
                hs.add(j);
                visited[i][j] = true;
                visited[j][i] = true;
                dfs(j, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        N = n;
        answer = N;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            boolean isConnect = false;
            for(int j=0; j<N; j++){
                if(i==j) continue;
                if(!visited[i][j] && computers[i][j]==1){
                    isConnect = true;
                    hs.add(i);
                    hs.add(j);
                    visited[i][j] = true;
                    visited[j][i] = true;
                    dfs(j, computers);
                }
            }
            if(isConnect){
                answer = answer - hs.size() + 1;
                hs.clear();
            }
        }
        return answer;
    }
}