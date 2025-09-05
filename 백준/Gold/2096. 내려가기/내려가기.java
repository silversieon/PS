import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] nums, dp;
    static int calculateMaxScore(){
        for(int i=1; i<=N; i++){
            dp[i][0] = Integer.max(dp[i-1][0] + nums[i][0], dp[i-1][1] + nums[i][0]);
            dp[i][1] = Integer.max(dp[i-1][1] + nums[i][1], Integer.max(dp[i-1][0] + nums[i][1], dp[i-1][2] + nums[i][1]));
            dp[i][2] = Integer.max(dp[i-1][2] + nums[i][2], dp[i-1][1] + nums[i][2]);
        }
        int max = -1;
        for(int numOflastline : dp[N]){
            max = Integer.max(max, numOflastline);
        }
        return max;
    }
    static int calculateMinScore(){
        for(int i=1; i<=N; i++){
            dp[i][0] = Integer.min(dp[i-1][0] + nums[i][0], dp[i-1][1] + nums[i][0]);
            dp[i][1] = Integer.min(dp[i-1][1] + nums[i][1], Integer.min(dp[i-1][0] + nums[i][1], dp[i-1][2] + nums[i][1]));
            dp[i][2] = Integer.min(dp[i-1][2] + nums[i][2], dp[i-1][1] + nums[i][2]);
        }
        int min = Integer.MAX_VALUE;
        for(int numOflastline : dp[N]){
            min = Integer.min(min, numOflastline);
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1][3];
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][3];
        System.out.println(calculateMaxScore() + " " + calculateMinScore());
    }
}