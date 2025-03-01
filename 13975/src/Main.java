import java.io.*;
import java.util.*;

public class Main {
    static int T, K;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            K = Integer.parseInt(br.readLine());
            long result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(K-->0){
                pq.add(Long.parseLong(st.nextToken()));
            }
            while(pq.size()!=1){
                Long X = pq.poll() + pq.poll();
                result+=X;
                pq.add(X);
            }
            sb.append(result).append('\n');
            pq.clear();
        }
        br.close();
        System.out.print(sb.toString());
    }
}