import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> index = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int max = -1;
            for(int i=0; i<N; i++){
                int x = Integer.parseInt(st.nextToken());
                max = Math.max(max, x);
                queue.add(x);
                index.add(i);
            }
            
            int count = 0;
            int nextMax = -1;
            while(!queue.isEmpty()){
                int output = queue.poll();
                int idx = index.poll();
                
                if(output<max){
                    nextMax = Math.max(nextMax, output);
                    queue.add(output);
                    index.add(idx);
                } else {
                    if(!queue.contains(max)){
                        max = nextMax;
                    }
                    count++;
                    if(idx == M){
                        break;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}