import java.util.*;
class Solution {
    public int[] solution(String msg) {
        // 각 문자열을 담는 색인 번호 표 map 만들고 A~Z 담기
        // 정답 배열을 ArrayList로 만들고, 문자열을 찾을 때마다 색인 번호 담기
        // 문자열은 첫 입력부터 순회하며 하되, 다음 문자를 포함한 글자가 사전에 있다면 다음문자까지 포함하기 (idx 단조 증가x)
        Map<String, Integer> dict = new HashMap<>();
        for(int i=0; i<26; i++) dict.put(String.valueOf((char)('A'+i)), i+1);
        List<Integer> answerList = new ArrayList<>();
        int i=0;
        
        while(i < msg.length()) {
            int j = i+1;       
            // 다음 글자가 map에 있는지 계산
            while(j<msg.length() && dict.containsKey(msg.substring(i, j+1))) j++;
            
            answerList.add(dict.get(msg.substring(i, j)));
            if(j<msg.length()) dict.put(msg.substring(i, j+1), dict.size() +1);
            i=j;
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
// 40분까지