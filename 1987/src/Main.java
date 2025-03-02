import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static HashSet<Character> hashset = new HashSet<>();
    static void DFS(int x, int y, int count){
        //3-1. Hashset에 해당 알파벳 저장
        hashset.add(board[x][y]);
        //3-2. 상하좌우 위치를 탐색, 조건에 만족하는 위치는 DFS 탐색
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !hashset.contains(board[nextX][nextY])){
                DFS(nextX, nextY, count+1);
            }
        }
        //3-3. 조건에 만족하지 않는 다면 HashSet에서 해당 알파벳 제거(백트래킹)
        hashset.remove(board[x][y]);
        //3-4. 지금까지 이동한 칸 최대 값 저장
        max = Integer.max(max, count+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 세로 R, 가로 C 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        //2. 알파벳을 배열 board에 저장
        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }
        //3. DFS 탐색 시작
        DFS(0, 0, 0);
        System.out.println(max);
    }
}