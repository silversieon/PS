import java.util.*;
class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "},{");
        Map<Integer, Integer> hash = new HashMap<>();
        while(st.hasMoreTokens()){
            Integer num = Integer.parseInt(st.nextToken());
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int[] answer = new int[hash.keySet().size()];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt((Integer[] a) -> a[1]).reversed());
        for(Integer num : hash.keySet()){
            pq.add(new Integer[]{num, hash.get(num)});
        }
        for(int i=0; i<answer.length; i++){
            answer[i] = pq.poll()[0];
        }
        return answer;
    }
}