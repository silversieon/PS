import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : A){
            pq_max.add(a);
        }
        Arrays.sort(B);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int b : B){
            dq.add(b);
        }
        while(!pq_max.isEmpty()){
            int target = pq_max.poll();
            if(target < dq.peekLast()){
                dq.pollLast();
                answer++;
            } else {
                dq.pollFirst();
            }
        }
        return answer;
    }
}