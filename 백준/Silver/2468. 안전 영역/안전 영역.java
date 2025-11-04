import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main{
    static int N, min = 101, max = 0, answer = 1;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(min, num);
                max = Math.max(max, num);
                map[i][j] = num;
            }
        }
        
        for(int k=min; k<max; k++){
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j]>k){
                        count++;
                        calcSafeRegion(visited, k, new Point(i, j));
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
    private static void calcSafeRegion(boolean[][] visited, int k, Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int curX = (int)cur.getX();
            int curY = (int)cur.getY();
            
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && !visited[nextX][nextY] && map[nextX][nextY]>k){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }
}