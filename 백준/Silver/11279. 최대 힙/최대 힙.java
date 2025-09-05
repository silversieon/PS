import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //Important

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else if(num>0){
                pq.add(num);
            }
        }
        System.out.print(sb);
        br.close();
    }
}
