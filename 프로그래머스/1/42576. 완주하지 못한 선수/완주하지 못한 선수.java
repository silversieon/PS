import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //1. participant 순회, HashMap에 +1 (동명이인이 있을 수 있으니 카운트)
        //2. completion 순회, HashMap의 value에서 -1
        //3. participant 순회, value가 1인 키 반환
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String player : participant) map.put(player, map.getOrDefault(player, 0) + 1);
        for(String player : completion) map.put(player, map.get(player) -1);
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}