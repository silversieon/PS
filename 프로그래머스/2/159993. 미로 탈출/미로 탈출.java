import java.util.*;
class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private int answer = Integer.MAX_VALUE;
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int startToLever = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j) == 'S') {
                    startToLever = bfs(maps, i, j, 'L');
                }
            }
        }
        if (startToLever == -1) return startToLever;
        int leverToExit = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j) == 'L') {
                    leverToExit = bfs(maps, i, j, 'E');
                }
            }
        }
        return leverToExit == -1 ? -1 : leverToExit+startToLever;
    }
    private int bfs(String[] maps, int sx, int sy, char target) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] dist = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dist[i][j] = -1;
            }
        }
        
        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            if(maps[cx].charAt(cy) == target) {
                return dist[cx][cy];
            }
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx].charAt(ny) != 'X' && dist[nx][ny] == -1) {
                q.add(new int[]{nx, ny});
                dist[nx][ny] = dist[cx][cy] + 1;
                }
            }
        }
        return -1;
    }
}
// 3분까지