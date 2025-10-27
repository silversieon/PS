import java.util.*;
class Solution {
    public String solution(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        String answer = "";
        for(int i=0; i<s.length(); i++){
            pq.add(s.substring(i, i+1));
        }
        for(int i=0; i<s.length(); i++){
            answer+=pq.poll();
        }
        return answer;
    }
}