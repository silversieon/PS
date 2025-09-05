import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] stuff, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stuff = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++){
            int weight = stuff[i][0];
            int value = stuff[i][1];
            for(int j=0; j<=K; j++){
                if(j>=weight){
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i-1][j-weight] + value);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}