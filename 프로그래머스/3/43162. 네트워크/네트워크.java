class Solution {
    private int answer=0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, computers, i, visited);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int n, int[][] computers, int idx, boolean[] visited) {
        for (int k=0; k<computers[idx].length; k++) {
            if(k!=idx && computers[idx][k] == 1 && !visited[k]) {
                visited[k] = true;
                dfs(n, computers, k, visited);
            }
        }
    }
}