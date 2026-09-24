import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 일반 큐와 우선 순위 큐에 priorities를 모두 삽입
        // 2. 일반 큐를 순회하며 우선 순위 큐의 peek와 다르면 다시 삽입
        // 3. 우선 순위 큐의 peek와 같다면 두 큐에서 모두 pop 하고 cnt 1 증가
        // 4. 원형 큐 형태를 생각해서 location의 위치 기억하여 location이 반환 될 때 cnt 값 리턴
        Queue<Integer> wait = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities) { // 1
            wait.add(priority);
            pq.add(priority);
        }
        int cnt = 0;
        while(!wait.isEmpty()) {
            int priority = wait.poll();
            if (priority != pq.peek()) { // 2
                wait.add(priority);
                location-=1;
                if(location < 0) location = wait.size()-1;
                continue;
            }
            pq.poll();
            cnt++;
            if(location == 0) return cnt;
            location-=1;
        }
        return cnt;
    }
    // ["1", 1] cnt4 location0
}