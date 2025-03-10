import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Queue<int[]> queue = new LinkedList<>();
    static int BFS(){
        queue.add(new int[]{N, 0});
        while (true) { 
            int[] A = queue.poll();
            if(A[0]==K){
                return A[1];
            }
                queue.add(new int[]{A[0]*2, A[1]+1});
                queue.add(new int[]{A[0]+1, A[1]+1});
                queue.add(new int[]{A[0]-1, A[1]+1});
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(BFS());
    }
}
