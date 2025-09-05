import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        List[] computers = new List[N+1];

        for(int i=1; i<=N; i++){
            computers[i] = new ArrayList<Integer>();
        }
        
        StringTokenizer st;
        for(int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }

        int[] visited = new int[N+1];

        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        while(!queue.isEmpty()){
            int target = queue.poll();
            visited[target] = 1;
            for(int i=0; i<computers[target].size(); i++){
                int next_target = (int)(computers[target].get(i));
                if(visited[next_target]!=1){
                    queue.add(next_target);
                }
            }
        }

        int count = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]==1){
                count++;
            }
        }
        System.out.println(count-1);
    }
}
