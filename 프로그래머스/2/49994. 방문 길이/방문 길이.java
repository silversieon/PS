import java.awt.Point;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public int solution(String dirs) {
        int answer = 0;
        int size = 5;
        boolean[][][] visited = new boolean[size*2+1][size*2+1][4];
        int x = size;
        int y = size;
        int d = 0;
        for(char c : dirs.toCharArray()){
            if(c == 'U') d = 0;
            if(c == 'R') d = 1;
            if(c == 'D') d = 2;
            if(c == 'L') d = 3;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx > size*2 || ny < 0 || ny > size*2) continue;
            if(!visited[x][y][d] || !visited[nx][ny][(d+2)%4]){
                visited[x][y][d] = true;
                visited[nx][ny][(d+2)%4] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}