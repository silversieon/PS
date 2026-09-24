import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> finishDays = new LinkedList<>();
        for(int i=0; i<speeds.length; i++) {
            finishDays.add((int)Math.ceil((100 - progresses[i]) / (double) (speeds[i])));
            System.out.println((int)Math.ceil((100 - progresses[i]) / speeds[i]));
        }
        List<Integer> list = new ArrayList<>();
        while(!finishDays.isEmpty()) {
            int progress = finishDays.poll();
            int v = 1;
            while(!finishDays.isEmpty() && finishDays.peek() <= progress) {
                finishDays.poll();
                v++;
            }
            list.add(v);
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
    // [7, 3, 9]
    // 5, 10, 1, 1, 20, 1
}