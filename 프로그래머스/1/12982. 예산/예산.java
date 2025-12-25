import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int n : d){
            budget -= n;
            answer += budget >= 0 ? 1 : 0;
            if(budget <= 0) break;
        }
        return answer;
    }
}