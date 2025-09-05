import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=N; j++){
                if(j==0){
                    table[i][j] = table[i-1][N];
                } else{
                    table[i][j] = table[i][j-1] + Integer.parseInt(st.nextToken());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int x = x1; x<=x2; x++){
                result += table[x][y2] - table[x][y1-1];
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb.toString());
    }
}