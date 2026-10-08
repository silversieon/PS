import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
      // 1. 의상 종류별 개수를 HashMap에 저장 (기본값 1, 안 입는 경우)
      // 2. HashMap의 KeySet을 순회하며 서로 곱한 후 -1(아무것도 안 입는 경우)
        int answer = 1;
        Map<String, Integer> typeCount = new HashMap<>();
        for (String[] cloth : clothes) {
            typeCount.put(cloth[1], typeCount.getOrDefault(cloth[1], 1) + 1);
        }
        for(String key : typeCount.keySet()){
            answer *= typeCount.get(key);
        }
        return answer - 1;
    }
}