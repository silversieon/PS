import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static void DFS(int num){
        stack.push(num);

        if(stack.size() == M){
            for(int i=0; i<M; i++){
                sb.append(stack.get(i)).append(" ");
            }
            sb.append("\n");
        }
        for(int i=num+1; i<N+1; i++){
            if(!stack.contains(i)){
                DFS(i);
                stack.pop();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<N+1; i++){
            DFS(i);
            stack.removeAllElements();
        }
        System.out.println(sb.toString());
    }
}
