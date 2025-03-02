import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dp;
    static int DFS(int x, int y){
        if(x==M-1 && y==N-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && (map[x][y]>map[nextX][nextY])){
                dp[x][y] += DFS(nextX, nextY);
            }
        }
        return dp[x][y];
    }   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        int result = DFS(0, 0);
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(result);
    }
}