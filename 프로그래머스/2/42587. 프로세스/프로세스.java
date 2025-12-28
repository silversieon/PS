import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    if(i == location){
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}