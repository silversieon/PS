import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            int[] sortedWood = new int[N];
            int[] resultWood = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                sortedWood[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(sortedWood);

            int lvalue = 0;
            int rvalue = N-1;
            for(int i=0; i<N; i++){
                if(i%2 == 0){
                    resultWood[lvalue] = sortedWood[i];
                    lvalue++;
                } else {
                    resultWood[rvalue] = sortedWood[i];
                    rvalue--;
                }
            }
            int max = 0;
            
            for(int i=0; i<N; i++){
                if(i==0){
                    max = Math.max(max, Math.abs(resultWood[i] - resultWood[N-1]));
                } else {
                    max = Math.max(max, Math.abs(resultWood[i] - resultWood[i-1]));
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb.toString());
    }
}