import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static int[][] countMove;
    static HashSet<Character> hashset = new HashSet<>();
    static void DFS(int x, int y, int count){
        countMove[x][y] = count+1;
        hashset.add(board[x][y]);
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !hashset.contains(board[nextX][nextY])){
                DFS(nextX, nextY, countMove[x][y]);
            }
        }
        hashset.remove(board[x][y]);
        max = Integer.max(max, countMove[x][y]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        countMove = new int[R][C];

        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }
        DFS(0, 0, 0);
        System.out.println(max);
    }
}