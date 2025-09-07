import java.util.*;
class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            int k = Integer.parseInt(st.nextToken());
            min = Math.min(min, k);
            max = Math.max(max, k);
        }
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}