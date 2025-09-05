import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        houses = new int[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][0], houses[i-1][1]);
        }
        int result  = Math.min(houses[N][0], (Math.min(houses[N][1], houses[N][2])));
        System.out.println(result);
    }
}