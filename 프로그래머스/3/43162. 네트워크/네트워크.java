class Solution {
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(n, computers, i);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int n, int[][] computers, int idx) {
        visited[idx] = true;
        for (int k=0; k<computers[idx].length; k++) {
            if(k!=idx && computers[idx][k] == 1 && !visited[k]) {
                dfs(n, computers, k);
            }
        }
    }
}