import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] node;
    static Queue<Integer> queue = new LinkedList<>();
    static HashMap<Integer, Integer> hash = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        node = new int[N][2];

        StringTokenizer st;
        int count = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(v1==1 || v2==1){
                if(v1==1){
                    queue.add(v2);
                    hash.put(v2, v1);
                    count++;
                } else {
                    queue.add(v1);
                    hash.put(v1, v2);
                    count++;
                }
            }
            node[i][0] = v1;
            node[i][1] = v2;
        }
        while(count!=N-1){
            int X = queue.poll();
            for(int i=0; i<N; i++){
                int v1 = node[i][0];
                int v2 = node[i][1];
                if(v1==X){
                    queue.add(v2);
                    hash.put(v2, X);
                    count++;
                } else {
                    queue.add(v1);
                    hash.put(v1, X);
                    count++;
                }
            }
        }
        for(int i=2; i<=N; i++){
            System.out.println(hash.get(i));
        }
    }
}
