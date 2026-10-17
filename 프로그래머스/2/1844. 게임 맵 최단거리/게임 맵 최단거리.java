import java.util.*;
class Node {
    int x;
    int y;
    int cnt;
    
    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getCnt() {
        return this.cnt;
    }
}
class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private int answer = Integer.MAX_VALUE;
    private boolean[][] visited;
    private Queue<Node> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        visited = new boolean[n][m];
        
        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int cX = node.getX();
            int cY = node.getY();
            int cnt = node.getCnt();
            
            if(cX==n-1 && cY==m-1) {
                answer = Math.min(answer, cnt);
                continue;
            }
            
            for (int i=0; i<4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX >=0 && nX<n && nY >=0 && nY<m && maps[nX][nY]==1 && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    queue.add(new Node(nX, nY, cnt+1));
                }
        }
        }
            
        return answer != Integer.MAX_VALUE ? answer : -1;
    }
}