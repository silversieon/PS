import java.io.*;

public class Main {
    static int N;
    static int[] score;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        score = new int[N+2];
        dp = new int[N+2][2];
        for(int i=2; i<N+2; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        for(int i=2; i<N+2; i++){
            dp[i][0] = score[i] + dp[i-1][1];
            dp[i][1] = score[i] + dp[i-1][0];
        }

        int result = Math.max(dp[N+1][0], dp[N+1][1]);
        System.out.println(result);
    }
}
