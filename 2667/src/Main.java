import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int DFS(int x, int y){
        int count_House = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];
                if(nextX < 0 || nextX >=N || nextY <0 || nextY >=N){
                    continue;
                }
                if(map[nextX][nextY]==0){
                    continue;
                }
                if(visited[nextX][nextY]==true){
                    continue;
                }
                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                count_House++;
            }
        }
        return count_House; 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        String str;
        for(int i=0; i<N; i++){
            str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        int count_DFS = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    count_DFS++;
                    pq.add(DFS(i, j));
                }
            }
        }
        System.out.println(count_DFS);
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
