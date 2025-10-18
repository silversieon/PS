import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pqmax.add(work);
        }
        while(n-->0){
            int num = pqmax.poll();
            if(num!=0){
                pqmax.add(num-1);
            } else {
                pqmax.add(num);
            }
        }
        while(!pqmax.isEmpty()){
            answer+= Math.pow(pqmax.poll(), 2);
        }
        return answer;
    }
}