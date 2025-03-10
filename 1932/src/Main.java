import java.io.*;
import java.util.*;

public class Main {
    static int N, max = -1;
    static int[][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        triangle = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<i; k++){
                triangle[i][k] = Integer.parseInt(st.nextToken());
                if(k==0){
                    triangle[i][k] += triangle[i-1][k];
                } else if(k==i){
                    triangle[i][k] += triangle[i-1][k-1];
                } else {
                    triangle[i][k] += Math.max(triangle[i-1][k-1], triangle[i-1][k]);
                }
                max = Math.max(max, triangle[i][k]);
            }
        }
        System.out.println(max);
    }
}
