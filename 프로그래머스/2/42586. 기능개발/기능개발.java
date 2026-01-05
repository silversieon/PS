import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> finishDay = new LinkedList<>();
        for(int i=0; i<speeds.length; i++){
            finishDay.offer((int)Math.ceil((100 - progresses[i]) / (double)(speeds[i])));
        }
        List<Integer> list = new ArrayList<>();
        while(!finishDay.isEmpty()){
            int progress = finishDay.poll();
            int v = 1;
            while(!finishDay.isEmpty() && progress>= finishDay.peek()){
                finishDay.poll();
                v++;
            }
            list.add(v);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}