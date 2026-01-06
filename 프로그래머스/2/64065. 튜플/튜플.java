import java.util.*;
class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "},{");
        Map<Integer, Integer> hash = new HashMap<>();
        while(st.hasMoreTokens()){
            Integer num = Integer.parseInt(st.nextToken());
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int size = hash.size();
        int[] answer = new int[size];
        for(Integer num : hash.keySet()){
            answer[size - hash.get(num)] = num;
        }
        return answer;
    }
}