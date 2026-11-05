import java.util.*;
class Solution {
    private static final int MULTIPLIER = 65536;
    public int solution(String str1, String str2) {
        // 문자열을 2개씩 순회하며 알파벳에 해당하는 것만 HashMap에 담기
        // HashMap 순회하며 비교 문자열 HashMap에 대조, 교집합 구하기
        // 교집합은 둘 중 원소가 작은 수의 개수, 합집합은 원소가 큰 수의 개수
        // 합집합이 0이면 1로 계산하고, 결과에 65536 곱하기
        Map<String, Integer> map1 = toMap(str1);
        Map<String, Integer> map2 = toMap(str2);
        
        Set<String> keys = new HashSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        int intersection = 0, union = 0;
        
        for(String k : keys) {
            int count1 = map1.getOrDefault(k, 0);
            int count2 = map2.getOrDefault(k, 0);
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        if(union == 0) return MULTIPLIER;
        return (int)(((double)intersection/union)*MULTIPLIER);
    }
    private Map<String, Integer> toMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<str.length()-1; i++) {
            String s = str.substring(i, i+2);
            s = s.toLowerCase();
            if(Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map.merge(s, 1, Integer::sum);
            }
        }
        return map;
    }
}