import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<elements.length; i++){
            queue.add(elements[i]);
            hs.add(elements[i]);
        }
        int k = elements.length-1;
        while(k-->0){
            queue.offer(queue.poll());
            for(int i=0; i<elements.length;  i++){
                int num = queue.poll();
                elements[i] += num;
                queue.offer(num);
                hs.add(elements[i]);
            }
        }
        return hs.size();
    }
}