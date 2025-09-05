import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. N, M 입력 받기
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //2. 누적 합을 저장할 S 선언 및 값 할당
        S = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        //3. M번 반복하며 구간 i, j 받기
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            //4. i~j까지의 합을 구하기 위해 누적합 방식 활용
            sb.append(S[j]-S[i-1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}