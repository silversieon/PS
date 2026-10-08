import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights)     {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            bridge.offer(0);
        }
        
        if (truck_weights.length == 1) return bridge_length + 1;
        if (bridge_length == 1) return truck_weights.length + 1;
        
        int idx = 0;
        int curWeight = 0;
        while(idx<truck_weights.length) {
            curWeight -= bridge.poll();
            answer++;
            
            if (curWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                curWeight += truck_weights[idx++];
            } else {
                bridge.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}