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
            int minSize = Integer.MAX_VALUE;
            int minIndex = 0;
            while(queue.size()!=1){
                for(int i=0; i<queue.size()-1; i++){
                    int A = queue.poll();
                    int B = queue.poll();
                    int X = A + B;
                    if(X<minSize){
                        minSize = X;
                        minIndex = i;
                    }
                    queue.add(A);
                    queue.add(B);
                }
                for(int i=0; i<queue.size()-2; i++){
                    if(i==minIndex){
                        int X = queue.poll() + queue.poll();
                        result+=X;
                        queue.add(X);
                    } else {
                        int C = queue.poll();
                        queue.add(C);
                    }
                }
            }
            sb.append(result).append('\n');
            queue.clear();
        }
        br.close();
        System.out.print(sb.toString());
    }
}