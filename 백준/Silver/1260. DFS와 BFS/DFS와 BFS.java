import java.util.*;
import java.io.*;

class Main{
    static int Edge_arr[][];
    static boolean Visited_arr[];
    static int N;
    static int M;
    static int V;
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void DFS(int start){
        stack.push(start);
        Visited_arr[start] = true;
        System.out.print(start + " ");
        while(!stack.isEmpty()){
            int vertex = stack.peek();
            boolean hasUnvisited = false;
            for(int i = 1; i <= N; i++){
                if(Edge_arr[vertex][i] == 1 && !Visited_arr[i]){
                    stack.push(i);
                    Visited_arr[i] = true;
                    System.out.print(i + " ");
                    hasUnvisited = true;
                    break;
                }
            }
            if(!hasUnvisited) {
                stack.pop();
            }
        }
    }
    public static void BFS(int start){
        queue.offer(start);	
		Visited_arr[start] = true;
		System.out.print(start + " ");

		while( !queue.isEmpty() ) {
			start = queue.poll();
			for(int i=1; i<=N; i++) {
				if(Edge_arr[start][i] == 1 && Visited_arr[i] == false) {
					queue.offer(i);
					Visited_arr[i] = true;
					System.out.print(i + " ");
				}
			}
		}	
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        Edge_arr= new int[1001][1001];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Edge_arr[x][y] = Edge_arr[y][x] = 1;
        }
        Visited_arr = new boolean[1001];
        DFS(V);
        System.out.println();
        Visited_arr = new boolean[1001];
        BFS(V);
    }
}