import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] P = new int[N+1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            P[i][0] = i; //개수
            P[i][1] = Integer.parseInt(st.nextToken()); //가격
        }
        
        int result = 0;
        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], P[i][1]+dp[i][j-P[i][0]]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}
