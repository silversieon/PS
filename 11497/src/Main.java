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
            int[] wood = new int[N];
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                Integer height = Integer.parseInt(st.nextToken());
                pq.add(height);
            }
            int lvalue = 0;
            int rvalue = N-1;
            while(!pq.isEmpty()){
                wood[lvalue] = pq.poll();
                lvalue++;
                if(!pq.isEmpty()){
                    wood[rvalue] = pq.poll();
                    rvalue--;
                } else {
                    break;
                }
            }
            for(int i=0; i<N; i++){
                System.out.println("wood : " + wood[i]);
            }
            int max = 0;
            
            for(int i=0; i<N; i++){
                if(i==0){
                    max = Math.max(max, Math.abs(wood[i] - wood[N-1]));
                } else {
                    max = Math.min(max, Math.abs(wood[i] - wood[i-1]));
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
