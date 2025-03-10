import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dp;
    static int DFS(int x, int y){
        //3-3. 오른쪽 아래 도달시 
        if(x==M-1 && y==N-1){
            return 1;
        }
        //3-4. 이미 경로의 수가 정해진 위치 
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        //3-1. 탐색 중임을 의미 
        dp[x][y] = 0;
        //3-2. 네 방면 탐색, 숫자가 낮다면 DFS탐색 이동
        for(int i=0; i<4; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && (map[x][y]>map[nextX][nextY])){
                dp[x][y] += DFS(nextX, nextY);
            }
        }
        //3-5. 더 이상 길이 없을 시 해당 위치에서 오른쪽 아래로 가는 경로의 수 반환
        return dp[x][y];
    }   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        //1. M, N 입력 받기, map, dp 크기 지정
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        //2. map과 dp에 값 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        //3. DFS 
        System.out.println(DFS(0, 0));
    }
}