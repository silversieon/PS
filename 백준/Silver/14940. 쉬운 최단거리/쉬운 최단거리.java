import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] visitied;
    static StringTokenizer st;
    static Queue<Point> queue = new LinkedList<>();
    static void BFS(Point target){
        int targetX = (int)target.getX();
        int targetY = (int)target.getY();
        visitied[targetX][targetY] = 1;
        map[targetX][targetY] = 0;
        queue.add(new Point(targetX, targetY));
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int curX = (int)cur.getX();
            int curY = (int)cur.getY();
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >=0 && nextX < N && nextY >=0 && nextY < M){
                    if(map[nextX][nextY]==1 && visitied[nextX][nextY] == 0){
                        visitied[nextX][nextY] = 1;
                        map[nextX][nextY] = map[curX][curY] + 1;
                        queue.add(new Point(nextX, nextY));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visitied = new int[N][M];

        Point target = new Point();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    target = new Point(i, j);
                }
            }
        }

        BFS(target);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1 && visitied[i][j] == 0){
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}