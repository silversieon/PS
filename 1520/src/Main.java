import java.io.*;
import java.util.*;

public class Main {
    static int M, N, countCourse = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] dp;
    static void DFS(int x, int y){
        if(x==M-1 && y==N-1){
            countCourse++;
            return;
        }
        boolean canMove = false;
        for(int i=0; i<4; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && (map[x][y]>map[nextX][nextY]) && !dp[nextX][nextY]){
                canMove = true;
                DFS(nextX, nextY);
            }
        }
        if(!canMove){
            dp[x][y] = true;
        }
    }   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new boolean[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = true;
        DFS(0, 0);
        System.out.println(countCourse);
    }
}