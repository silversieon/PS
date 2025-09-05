import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, day = Integer.MIN_VALUE;
    static int[][] tomatoBox;
    static boolean isPossible = true;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();
    static void BFS(){
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            int currentX = (int)(currentPoint.getX());
            int currentY = (int)(currentPoint.getY());
            for(int i=0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && tomatoBox[nextX][nextY]==0){
                    queue.offer(new Point(nextX, nextY));
                    tomatoBox[nextX][nextY] = tomatoBox[currentX][currentY] + 1;
                }
            }
        }
    }
    static int caculateDays(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomatoBox[i][j]==0){
                    isPossible = false;
                    break;
                }
                day = Math.max(tomatoBox[i][j], day);
            }
        }
        return isPossible ? day-1 : -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoBox = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomatoBox[i][j]==1){
                    queue.offer(new Point(i, j));
                }
            }
        }
        BFS();
        System.out.println(caculateDays());
    }
}