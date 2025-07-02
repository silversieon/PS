import java.io.*;
import java.util.*;

public class App {
    static int N, dasom, count = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());
        while(N-->1){
            int a = Integer.parseInt(br.readLine());
            pq.add(a);
        }
        
        if(!pq.isEmpty()){
            while(dasom<=pq.peek()){
                dasom+=1;
                pq.add(pq.poll()-1);
                count++;
            }
        }

        System.out.println(count);
    }
}
