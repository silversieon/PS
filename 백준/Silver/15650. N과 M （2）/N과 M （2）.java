import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static void DFS(int num){

        if(stack.size() == M){
            for(int i=0; i<M; i++){
                sb.append(stack.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=num+1; i<N+1; i++){
            if(!visited[i]){
                visited[i] = true;
                stack.push(i);
                DFS(i);
                visited[i] = false;
                stack.pop();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        DFS(0);
        System.out.println(sb.toString());
    }
}