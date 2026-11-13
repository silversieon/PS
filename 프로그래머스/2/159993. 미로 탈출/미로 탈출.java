import java.util.*;
class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    public int solution(String[] maps) {
        int sx = 0, sy = 0, lx = 0, ly = 0;
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if(c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
        int toLever = bfs(maps, sx, sy, 'L');
        if (toLever == -1) return -1;
        
        int toExit = bfs(maps, lx, ly, 'E');
        if (toExit == -1) return -1;
        
        return toLever + toExit;
    }
    private int bfs(String[] maps, int sx, int sy, char target) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[][] dist = new int[n][m];
        for(int[] row : dist) Arrays.fill(row, -1);
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            
            if(maps[cx].charAt(cy) == target) {
                return dist[cx][cy];
            }
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx].charAt(ny) != 'X' && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}