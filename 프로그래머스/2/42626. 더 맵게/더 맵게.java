import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
    // 1. scoville 값들을 모두 우선순위큐에 넣는다.
    // 2. 가장 낮은 scoville 값을 꺼내고, 7보다 작다면 섞는다.
    // 3. 다시 우선순위 큐에 넣고 위 과정을 반복한다.
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int v : scoville) {
        pq.add(v);
    }
    while(!pq.isEmpty()) {
        int first = pq.poll();
        if (first < K) {
            if (pq.isEmpty()) return -1;
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
    }
    return answer;
    }
}