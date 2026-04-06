class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int n = board.length;
        
        for(int i=0; i<4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];
            if(nx >= 0 && nx < n && ny >=0 && ny < n && board[h][w].equals(board[nx][ny])) {
                answer++;
            }
        }
        return answer;
    }
}