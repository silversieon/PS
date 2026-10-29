import java.util.*;
class Solution {
    private final static String DIR = "NSWE";
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public int[] solution(String[] park, String[] routes) {
        int W = park.length;
        int H = park[0].length();
        int r=0, c=0;
        for (int i=0; i<W; i++){
            int k = park[i].indexOf("S");
            if (k != -1) {
                r = i;
                c = k;
                break;
            }
        }
        
        for(String route : routes) {
            int d = DIR.indexOf(route.charAt(0));
            int n = Integer.parseInt(route.substring(2));
            
            boolean canMove = true;
            int nx = r, ny = c;
            for(int i=0; i<n; i++) {
                nx += dx[d];
                ny += dy[d];
                if(nx < 0 || nx >= W || ny < 0 || ny >= H || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }
            if (canMove) {
                r = nx;
                c = ny;
            }
        }
        return new int[]{r, c};
    }
}