import java.util.*;
class Solution {
    public int[] solution(String msg) {
        // 각 문자열을 담는 색인 번호 표 map 만들고 A~Z 담기
        // 정답 배열을 ArrayList로 만들고, 문자열을 찾을 때마다 색인 번호 담기
        // 문자열은 첫 입력부터 순회하며 하되, 다음 문자를 포함한 글자가 사전에 있다면 다음문자까지 포함하기 (idx 단조 증가x)
        Map<String, Integer> map = new HashMap<>();
        char c = 'A';
        for(int i=1; i<=26; i++) {
            map.put(String.valueOf((char)(c+(i-1))), i);
        }
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;
        int lastNum = 27;
        StringBuilder sb = new StringBuilder();
        while(idx<msg.length()) {
            // 첫 입력 더하기
            String s = msg.substring(idx, idx+1);
            
            // 다음 글자가 map에 있는지 계산
            while(idx+1<msg.length() && map.getOrDefault(s+msg.substring(idx+1, idx+2), 0) != 0) {
                s += msg.substring(idx+1, idx+2);
                idx++;
            }
            
            answerList.add(map.get(s));
            if(idx+1<msg.length()) map.put(s+msg.substring(idx+1, idx+2), lastNum++);
            idx++;
            sb.setLength(0);
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
// 40분까지