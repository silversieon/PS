import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int t : tangerine){
            hash.put(t, hash.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(hash.keySet());
        list.sort((o1, o2) -> hash.get(o2) - hash.get(o1));
        for(int key: list){
            k -=hash.get(key);
            answer++;
            if(k<=0) break;
        }
        return answer;
    }
}