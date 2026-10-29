import java.util.*;
class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public int[] solution(String[] park, String[] routes) {
        int W = park.length;
        int H = park[0].length();
        int[] pos = new int[2];
        for (int i=0; i<W; i++){
            String s = park[i];
            for(int j=0; j<H; j++){
                if(s.charAt(j) == 'S') {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        
        for(String route : routes) {
            String[] move = route.split(" ");
            int count = Integer.parseInt(move[1]);
            int k = -1;
            if(move[0].equals("N")) {
                k=0;
            } else if (move[0].equals("S")) {
                k=1;
            } else if (move[0].equals("W")) {
                k=2;
            } else {
                k=3;
            }
            boolean impossible = false;
            int cx = pos[0];
            int cy = pos[1];
            for(int i=0; i<count; i++) {
                int nx = pos[0]+dx[k];
                int ny = pos[1]+dy[k];
                if(nx < 0 || nx >= W || ny < 0 || ny >= H || park[nx].charAt(ny) == 'X') {
                    impossible = true;
                    break;
                }
                pos[0] = nx;
                pos[1] = ny;
            }
            if (impossible) {
                pos[0] = cx;
                pos[1] = cy;
            }
        }
        return new int[]{pos[0], pos[1]};
    }
}