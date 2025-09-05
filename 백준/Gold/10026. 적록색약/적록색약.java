import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int N;
    static char[][] arr;
    static int count_location =0;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];
                if(nextX<0 || nextX>=N || nextY <0||nextY>=N){
                    continue;
                }
                if(arr[currentPoint.x][currentPoint.y]!=arr[nextX][nextY]){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.offer(new Point(nextX, nextY));
            }
        }
        count_location++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    BFS(i, j);
                }
            }
        }
        sb.append(count_location+ " ");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]=='G'){
                    arr[i][j] = 'R';
                }
                visited[i][j] = false;
            }
        }
        count_location = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    BFS(i, j);
                }
            }
        }
        sb.append(count_location);
        System.out.println(sb.toString());
    }
}
