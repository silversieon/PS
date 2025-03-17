import java.io.*;
import java.util.*;

public class Main {
    static int N, max = -1;
    static int[][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 정삼각형의 크기 N
        N = Integer.parseInt(br.readLine());
        //2. 삼각형 각 위치에서의 최대 값 저장할 변수
        triangle = new int[N+1][N+1];
        //3. 2중 for문을 통해 값 저장, 조건은 다음과 같음
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //3-1. 왼쪽위 대각선 값, 오른쪽위 대각선 값 중 큰 값 + 입력 값
            for(int k=1; k<=i; k++){
                triangle[i][k] = Math.max(triangle[i-1][k-1], triangle[i-1][k]) + Integer.parseInt(st.nextToken());
                //4. max 최대값 계속 갱신
                max = Math.max(max, triangle[i][k]);
            }
        }
        //4. max 값 출력
        System.out.println(max);
    }
}
