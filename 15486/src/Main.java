import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, max = -1;
    static int[] dp;
    static int[][] work;
    static void DFS(int day, int money){
        if(day > N){
            max = Math.max(max, money);
            return;
        }
        DFS(day + 1, money);
        if(day + work[day][0] <= N+1 ){
            DFS(day + work[day][0], money + work[day][1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        work = new int[N+1][2];
        dp = new int[N+1];
        for(int i=1; i<=N; i++){ 
            StringTokenizer st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }
        DFS(1, 0);
        System.out.println(max);
    }
}
