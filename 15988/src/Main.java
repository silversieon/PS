import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        long[] dp = new long[1000001];
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
        final int mod = 1000000009;
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            for(int i=4; i<=N; i++){
                dp[i] = (dp[i-3] + dp[i-2] + dp[i-1])%mod;
            }
            sb.append(dp[N]).append('\n');
        }
        System.out.print(sb.toString());
    }
}