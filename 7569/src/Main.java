import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H, days = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    static Queue<Point> queue = new LinkedList<>();
    static void calculateDays(){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int currentX = (int)point.getX();
            int currentY = (int)point.getY();
            for(int i=0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextX<N*H && nextY>=0 && nextY<M && box[nextX][nextY]==0){
                    box[nextX][nextY] = box[currentX][currentY] + 1;
                    queue.add(new Point(nextX, nextY));
                }
            }
            int tmpX = currentX - N;
            while(tmpX>0 && box[tmpX][currentY]==0){
                    box[tmpX][currentY] = box[currentX][currentY] + 1;
                    queue.add(new Point(tmpX, currentY));
                    tmpX -=N;
            }
            tmpX = currentX + N;
            while(tmpX<N*H  && box[tmpX][currentY]==0){
                box[tmpX][currentY] = box[currentX][currentY] + 1;
                queue.add(new Point(tmpX, currentY));
                tmpX +=N;
            }
        }
    }
    static void checkBox(){
        for(int i=0; i<N*H; i++){
            for(int j=0; j<M; j++){
                if(box[i][j]==0){
                    days = -1;
                    return;
                } else {
                    days = Math.max(days, box[i][j]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N*H][M];

        for(int i=0; i<N*H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1){
                    queue.add(new Point(i, j));
                }
            }
        }
        calculateDays();
        checkBox();
        days = days>=1 ? days-1 : days;
        System.out.println(days);
    }
}