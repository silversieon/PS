import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        for(int i=0; i<N; i++){
            for(int j=1; j<K; j++){
                int tmp = queue.poll();
                queue.add(tmp);
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append(", ");
            }
            else{
                sb.append(">");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
