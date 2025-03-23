import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[] coins;
    static int[][] coinValue, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            coins = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            int coinCounter = M/coins[1]+1;

            coinValue = new int[N+1][coinCounter];
            for(int i=1; i<=N; i++){
                for(int k=0; k<coinCounter; k++){
                    coinValue[i][k] = coins[i]*k;
                }
            }
            dp = new int[N+1][coinCounter];
            for(int i=1; i<=N; i++){
                for(int k=0; k<coinCounter; k++){
                    int needValue = M-coinValue[i][k];
                }
            }
        }
    }
}
