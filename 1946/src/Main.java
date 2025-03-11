import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            Integer[][] applicants = new Integer[N][2];
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(applicants, 0, N, Comparator.comparingInt(a->a[0]));
            int count = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                int interviewScore = applicants[i][1];
                boolean isHired = true;
                if(interviewScore>min){
                    isHired = false;
                } else {
                    min = interviewScore;
                }
                if(isHired) count++;   
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb.toString());
    }
}
