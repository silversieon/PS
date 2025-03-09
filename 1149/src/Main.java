import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] houses;
    static int caculateMinCost(){
        for(int k=1; k<=N; k++){
            houses[k][0] += Math.min(houses[k-1][1], houses[k-1][2]);
            houses[k][1] += Math.min(houses[k-1][0], houses[k-1][2]);
            houses[k][2] += Math.min(houses[k-1][0], houses[k-1][1]);
        }
        return Math.min(houses[N][0], (Math.min(houses[N][1], houses[N][2])));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        houses = new int[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(caculateMinCost());
    }
}
