import java.util.*;
import java.awt.Point;
class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int min = 10000;
    private void bfs(int[][] maps){
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            int curX = (int)(p.getX());
            int curY = (int)(p.getY());
            if(curX == N-1 && curY == M-1){
                min = Math.min(min, maps[curX][curY]);
                break;
            }
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && maps[nextX][nextY] == 1 && visited[nextX][nextY] == false){
                    visited[nextX][nextY] = true;
                    maps[nextX][nextY] += maps[curX][curY];
                    q.add(new Point(nextX, nextY));
                }
            }
        }
        if(min == 10000) min = -1;
    }
    public int solution(int[][] maps) {
        bfs(maps);
        return min;
    }
}