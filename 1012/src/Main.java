import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    static void BFS(int[][] field, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(field[i][j]==1 && !visited[i][j]){
                    queue.add(new Point(i, j));
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        int x = (int)p.getX();
                        int y = (int)p.getY();
                        for(int k=0; k<4; k++){
                            int nextX = x + dx[k];
                            int nextY = y + dy[k];
                            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && field[nextX][nextY]==1 && !visited[nextX][nextY]){
                                visited[nextX][nextY] = true;
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                    }
                    count++;
                }
            }
        }
        sb.append(count).append('\n');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[][] field = new int[M][N];
            boolean[][] visited = new boolean[M][N];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            BFS(field, visited);
        }
        System.out.print(sb.toString());
    }
}
