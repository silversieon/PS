import java.io.*;
import java.util.*;

public class Main {
    static int T, I, targetX = 0, targetY = 0;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][] visited;
    static int BFS(int currentX, int currentY){
        Queue<Integer[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        queue.add(new Integer[]{currentX, currentY, 0});
        while(!queue.isEmpty()){
            Integer[] currentPoint = queue.poll();
            int X = currentPoint[0];
            int Y = currentPoint[1];
            int C = currentPoint[2];
            if(X==targetX && Y==targetY){
                return C;
            }
            for(int i=0; i<8; i++){
                int nextX = X + dx[i];
                int nextY = Y + dy[i];
                if(nextX>=0 && nextX<I && nextY>=0 && nextY<I && visited[nextX][nextY]==false){
                    visited[nextX][nextY] = true;
                    queue.add(new Integer[]{nextX, nextY, C+1});
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            sb.append(BFS(currentX, currentY)).append('\n');
        }
        System.out.print(sb.toString());
    }
}