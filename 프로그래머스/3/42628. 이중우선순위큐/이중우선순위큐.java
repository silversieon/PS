import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqmin = new PriorityQueue<>();
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder());
        for(String operation : operations){
            if(operation.startsWith("I ")){
                int num = Integer.parseInt(operation.substring(2));
                pqmin.add(num);
                pqmax.add(num);
            } else {
                if(operation.equals("D 1")){
                    pqmin.remove(pqmax.poll());
                } else if(operation.equals("D -1")){
                    pqmax.remove(pqmin.poll());
                }
            }
        }
        if(pqmin.isEmpty() && pqmax.isEmpty()) return new int[]{0, 0};
        return new int[]{pqmax.poll(), pqmin.poll()};
    }
}