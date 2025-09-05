import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] book = new int[M+1][2];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            book[i][0] = Integer.parseInt(st.nextToken());
            book[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[M+1][N+1];

        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(j-book[i][0]>=0){
                    dp[i][j] = Integer.max(book[i][1]+dp[i-1][j-book[i][0]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[M][N]);
    }
}