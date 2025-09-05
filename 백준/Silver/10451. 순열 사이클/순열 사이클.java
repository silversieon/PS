import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int N;
    static int count;
    static int[] arr;
    static boolean[] visited; 
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            count = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                visited[i] = false;
            }
            for(int i=1; i<N+1; i++){
                if(!visited[i]){
                    visited[i] = true;
                    int next = arr[i];
                    while(true){
                        if(visited[next]){
                            count++;
                            break;
                        }
                        visited[next] = true;
                        next = arr[next];
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
