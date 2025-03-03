import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int K;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            K = Integer.parseInt(br.readLine());
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(K-->0){
                queue.add(Integer.parseInt(st.nextToken()));
            }
            while(queue.size()!=1){
                
            }
            sb.append(result).append('\n');
            queue.clear();
        }
        br.close();
        System.out.print(sb.toString());
    }
}