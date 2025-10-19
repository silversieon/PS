import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i=0; i<discount.length - days + 1; i++){
            Map<String, Integer> dayMap = new HashMap<>();
            
            for(int d=0; d<days; d++){
                dayMap.put(discount[i+d], dayMap.getOrDefault(discount[i+d], 0) + 1);
            }
            
            boolean isIdentical = true;
            
            for(String key : map.keySet()){
                if(map.get(key)!= dayMap.get(key)){
                    isIdentical = false;
                }
            }
            if(isIdentical) answer++;
        }
        return answer;
    }
}