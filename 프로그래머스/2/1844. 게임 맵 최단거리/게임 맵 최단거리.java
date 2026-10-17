import java.util.*;
class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int answer = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.add(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int cX = node[0];
            int cY = node[1];
            int cnt = node[2];
            
            if(cX==n-1 && cY==m-1) {
                answer = Math.min(answer, cnt);
                continue;
            }
            
            for (int i=0; i<4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX >=0 && nX<n && nY >=0 && nY<m && maps[nX][nY]==1 && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    queue.add(new int[]{nX, nY, cnt+1});
                }
        }
        }
            
        return answer != Integer.MAX_VALUE ? answer : -1;
    }
}