class Solution {
    public int solution(String s) {
        // StringBuilder를 이용해 문자 하나씩 붙이기
        // 만약 현재 문자가 이전 문자의 인덱스와 같다면 이전 문자 제거
        // 그렇지 않다면 문자 더하기
        // s를 전부 순회하고 StringBuilder 길이가 0이 면 1반환, 아니면 0반환
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(c);
                continue;
            }
            if(c == sb.charAt(sb.length()-1)) {
                sb.setLength(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.length() == 0 ? 1 : 0;
    }
}