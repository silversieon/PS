import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        if(N!=1){
            int result = 0;
            while(pq.size()!=1){
                int X = pq.poll() + pq.poll();
                result+=X;
                pq.add(X);
            }
            System.out.println(result);
        } else {
            System.out.println(0);
        }

    }
}