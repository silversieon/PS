import java.util.*;
class Solution {
    public int[] solution(String s) {
        // s의 각 인덱스를 순회하며 '{'를 만날 시 int 배열에 담아 List에 저장
        // 각 int 배열 길이에 따라 List를 정렬하고 순회하며 result에 담기 (HashSet 사용?)
        String[] strs = s.substring(2, s.length()-2).split("\\},\\{");
        Arrays.sort(strs, (a, b) -> Integer.compare(a.length(), b.length()));
        
        Set<Integer> set = new HashSet<>();
        List<Integer> answerList = new ArrayList<>();
        for(String str: strs){
            String[] nums = str.split(",");
            for(String num : nums) {
                Integer n = Integer.parseInt(num);
                if(!set.contains(n)) {
                    answerList.add(n);
                    set.add(n);
                }
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}