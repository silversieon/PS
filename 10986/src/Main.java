import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M, count = 0;
    static long[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        A = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = A[i-1] + Long.parseLong(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            System.out.println(A[i]);
        }
        System.out.println(count);
    }
}