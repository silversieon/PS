import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hashmap = new HashMap<>();
        for(String[] cloth : clothes){
            hashmap.put(cloth[1], hashmap.getOrDefault(cloth[1], 1)+1);
        }
        Set<String> keySet = hashmap.keySet();
        for(String key : keySet){
            answer *= hashmap.get(key);
        }
        
        return answer-1;
    }
}