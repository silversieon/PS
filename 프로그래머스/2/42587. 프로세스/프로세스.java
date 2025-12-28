import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int target = priorities[location];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
            q.add(new Integer[]{priorities[i], i});
        }
        while(true){
            int process = pq.poll();
            while(process!=q.peek()[0]){
                q.add(q.poll());
            }
            if(q.peek()[0]!=target) q.poll();
            else {
                if(q.peek()[1] != location) q.poll();
                else {
                    answer++;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}