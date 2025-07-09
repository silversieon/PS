import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H, countDays = 0, countRipeTomato = 0;
    static int dx[];
    static int dy[];
    static int[][] box;
    static Queue<Point> ripeTomato = new LinkedList<>();
    static StringTokenizer st;
    static void BFS(){
        while(!ripeTomato.isEmpty()){
            if(countRipeTomato == 0){
                countDays++;
                countRipeTomato = ripeTomato.size();
            }
            countRipeTomato--;
            Point curPoint = ripeTomato.poll();
            int curX = (int)curPoint.getX();
            int curY = (int)curPoint.getY();
            for(int i=0; i<6; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextX < N*H && nextY >= 0 && nextY < M && box[nextX][nextY] == 0){
                    if((dx[i] == 1 && nextX%N == 0) || (dx[i] == -1 && nextX%N == N-1)){
                        continue;
                    }
                    box[nextX][nextY] = 1;
                    ripeTomato.add(new Point(nextX, nextY));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N*H][M];
        dx = new int[]{-1, 1, 0, 0, -N, N};
        dy = new int[]{0, 0, -1, 1, 0, 0};

        for(int i=0; i<N*H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    ripeTomato.add(new Point(i, j));
                    countRipeTomato++;
                }
            }
        }
        BFS();

        for(int i=0; i<N*H; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0){
                    countDays = -1;
                    break;
                }
            }
        }
        System.out.println(countDays);
    }
}