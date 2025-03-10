import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 집의 수 N
        N = Integer.parseInt(br.readLine());
        //2. RGB 최소 비용 저장할 변수
        houses = new int[N+1][3];
        //3. 1~N까지 비용 입력 받음과 동시에 이전 집의 다른 두 색깔 중 최소 비용을 더함으로써 최소 비용 계속 저장
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][0], houses[i-1][1]);
        }
        //4. N번째 집의 RGB 중 최소 비용 출력
        int result  = Math.min(houses[N][0], (Math.min(houses[N][1], houses[N][2])));
        System.out.println(result);
    }
}
