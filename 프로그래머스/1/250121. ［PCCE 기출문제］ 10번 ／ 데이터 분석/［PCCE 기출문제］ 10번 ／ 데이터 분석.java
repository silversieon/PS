import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extCode = changeValue(ext);
        int cnt = 0;
        for(int[] d : data) {
            if(d[extCode] < val_ext) cnt++;
        }
        int[][] answer = new int[cnt][4];
        int idx = 0;
        for(int[] d : data) {
            if(d[extCode] < val_ext) {
                answer[idx++] = d;
            }
        }
        Arrays.sort(answer, (a, b) -> {
            int sortCode = changeValue(sort_by);
            return a[sortCode] - b[sortCode];
        });
        return answer;
    }
    private int changeValue(String s) {
        if(s.equals("code")) return 0;
        else if(s.equals("date")) return 1;
        else if(s.equals("maximum")) return 2;
        else if(s.equals("remain")) return 3;
        else return -1;
    }
}