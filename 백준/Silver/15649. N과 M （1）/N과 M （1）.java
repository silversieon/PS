import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static void DFS(int num){
        stack.push(num);
        if(stack.size() == M){
            for(int i=0; i<M; i++){
                sb.append(stack.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<N+1; i++){
            if(!stack.contains(i)){
                DFS(i);
                stack.pop();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];

        for(int i=1; i<N+1; i++){
            nums[i]= i+1;
        }

        for(int i=1; i<N+1; i++){
            DFS(i);
            stack.removeAllElements();
        }
        System.out.println(sb.toString());
    }
}