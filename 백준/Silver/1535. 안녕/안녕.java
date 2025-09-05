import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] person = new int [N+1][2];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            person[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            person[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int [N+1][100];

        for(int i=1; i<=N; i++){
            int lose_health = person[i][0];
            for(int j=0; j<100; j++){
                if(lose_health<=j){
                    dp[i][j] = Integer.max(person[i][1]+dp[i-1][j-lose_health], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}