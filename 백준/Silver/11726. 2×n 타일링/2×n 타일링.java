import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+3];
        dp[1] = 1;
        dp[2] = 2;
        if(N >=3){
            for(int i=3; i<N+1; i++){
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
        }
        System.out.println(dp[N]);
    }
}