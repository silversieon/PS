import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static void DFS(){
        if(stack.size() == M){
            for(int i=0; i<M; i++){
                sb.append(stack.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<N+1; i++){
            stack.push(i);
            DFS();
            stack.pop();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DFS();
        System.out.println(sb.toString());
    }
}