import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int item : scoville) pq.add(item);
        while(pq.peek() < K){
            if(pq.size() == 1) return -1;
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        return answer;
    }
}