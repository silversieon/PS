import java.io.*;

public class Main {
    static int N;
    static int[] score, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        score = new int[N+3];
        dp = new int[N+3];
        for(int i=3; i<N+3; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(dp[N+2]);
    }
}
