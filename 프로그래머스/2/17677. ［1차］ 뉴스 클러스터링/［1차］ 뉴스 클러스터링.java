import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        // 문자열을 2개씩 순회하며 알파벳에 해당하는 것만 HashMap에 담기
        // HashMap 순회하며 비교 문자열 HashMap에 대조, 교집합 구하기
        // 교집합은 둘 중 원소가 작은 수의 개수, 합집합은 원소가 큰 수의 개수
        // 합집합이 0이면 1로 계산하고, 결과에 65536 곱하기
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int map1Size = 0;
        int map2Size = 0;
        for(int i=0; i<str1.length()-1; i++) {
            String s = str1.substring(i, i+2);
            s = s.toLowerCase();
            if(Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map1.merge(s, 1, Integer::sum);
                map1Size++;
            }
        }
        for(int i=0; i<str2.length()-1; i++) {
            String s = str2.substring(i, i+2);
            s = s.toLowerCase();
            if(Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map2.merge(s, 1, Integer::sum);
                map2Size++;
            }
        }
        int crossCount = 0;
        for(Map.Entry<String, Integer> e : map1.entrySet()) {
            if(map2.get(e.getKey()) != null) {
                crossCount += Math.min(e.getValue(), map2.get(e.getKey()));
            }
        }
        int sumCount = map1Size + map2Size - crossCount;
        return sumCount == 0 ? 65536 : (int)(((double)crossCount/sumCount)*65536);
    }
}