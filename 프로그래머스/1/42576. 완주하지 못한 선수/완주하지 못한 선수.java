import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //1. participant 순회, HashMap에 +1 (동명이인이 있을 수 있으니 카운트)
        //2. completion 순회, HashMap의 value에서 -1
        //3. participant 순회, value가 1인 키 반환
        Map<String, Integer> map = new HashMap<>();
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for(String comp : completion) {
            map.put(comp, map.get(comp) -1);
        }
        for(String part : participant) {
            if(map.get(part) != 0) {
                return part;
            }
        }
        return "";
    }
}