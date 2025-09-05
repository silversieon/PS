import java.io.*;
import java.util.*;

public class Main {
    static int T, N, result;
    static int[][] sticker, dp;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());

            //j인덱스 -2까지 계산해야하므로 배열 크기 +2 잡기
            sticker = new int[2][N+2];
            dp = new int[2][N+2];

            for(int i=0; i<2; i++){
                    st = new StringTokenizer(br.readLine());
                for(int j=2; j<N+2; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            //본인 위치 + (대각선과 대각선-1 위치 중 큰 값을 dp 배열에 저장)
            for(int j=2; j<N+2; j++){
                for(int i=0; i<2; i++){
                    if(i==0){
                        dp[i][j] = sticker[i][j] + Math.max(dp[i+1][j-2], dp[i+1][j-1]);
                    } else {
                        dp[i][j] = sticker[i][j] + Math.max(dp[i-1][j-2], dp[i-1][j-1]);
                    }
                }
            }
            result = Math.max(dp[0][N+1], dp[1][N+1]);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}