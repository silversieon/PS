import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int num = Integer.parseInt(st.nextToken());
            if(num==0){
                if(pq.isEmpty()){{
                    sb.append(-1).append("\n");
                }}
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                for(int j=0; j<num; j++){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
