import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    static void DFS(int node){
        visited[node] = true;
        for(int next : graph[node]){
            if(!visited[next]){
                DFS(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
