import java.util.*;
import java.util.regex.*;
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.replaceAll("[^0-9,]", "");
        String[] arr = s.split(",");
        for(String num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
}