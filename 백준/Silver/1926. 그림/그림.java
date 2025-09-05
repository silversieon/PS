import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count_painting = 0, max_area = 0;
    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, 1, -1};
    static int painting[][];
    static boolean visited[][];
    static StringBuilder sb = new StringBuilder();
    static Queue<Point> queue = new LinkedList<>();
    static void BFS(int x, int y){
        int count_area = 1;
        visited[x][y] = true;
        queue.offer(new Point(x, y));

        while(!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curX = (int)(curPoint.getX());
            int curY = (int)(curPoint.getY());

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >=0 && nextX <N && nextY >=0 && nextY < M && painting[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    count_area++;
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        max_area = Math.max(max_area, count_area);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        painting = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                painting[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(painting[i][j] == 1 && !visited[i][j]){
                    count_painting++;
                    BFS(i, j);
                }
            }
        }
        sb.append(count_painting).append("\n").append(max_area);
        System.out.println(sb.toString());
    }
}