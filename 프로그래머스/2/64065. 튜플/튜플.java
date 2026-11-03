import java.util.*;
class Solution {
    public int[] solution(String s) {
        // s를 숫자 배열만 남도록 파싱하고 String 배열에 담기
        // String 배열을 문자열 길이 순 정렬
        // String 배열을 순회하며 튜플에 원소 저장, 만약 한 번이라도 만난적 있는 순자라면(HashSet 사용) 건너뛰기
        String[] strs = s.substring(2, s.length()-2).split("\\},\\{");
        Arrays.sort(strs, (a, b) -> Integer.compare(a.length(), b.length()));
        
        Set<Integer> set = new HashSet<>();
        List<Integer> answerList = new ArrayList<>();
        for(String str: strs){
            String[] nums = str.split(",");
            for(String num : nums) {
                int n = Integer.parseInt(num);
                if(set.add(n)) {
                    answerList.add(n);
                }
            }
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}