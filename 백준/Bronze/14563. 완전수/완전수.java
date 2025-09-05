import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> list = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(C-->0){
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i=1; i<N; i++){
                if(N%i==0){
                    list.add(i);
                }
            }
            while(!list.isEmpty()){
                sum += list.poll();
            }
            String str = ((sum==N) ? "Perfect" : (sum<N) ? "Deficient" : "Abundant");
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
