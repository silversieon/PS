import java.io.*;
import java.util.*;

public class Myanswer {
    static int T;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int findMax(Queue<Integer> queue, int max){
        for(int i=max; i>0; i--){
            if(queue.contains(i)){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int max = -1;
            for(int i=0; i<N; i++){
                int x = Integer.parseInt(st.nextToken());
                max = Math.max(max, x);
                queue.add(x);
            }

            int result = 0;
            while(!queue.isEmpty()){
                int output = queue.poll();

                if(output<max){
                    if(M == 0){
                        M = queue.size();
                    } else {
                        M--;
                    }
                    queue.add(output);
                } else {
                    result++;
                    if(M == 0){
                        break;
                    }
                    max = findMax(queue, max);
                    M--;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}