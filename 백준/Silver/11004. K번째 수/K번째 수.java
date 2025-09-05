import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<K-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
