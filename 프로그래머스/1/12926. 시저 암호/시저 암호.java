class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(Character.isLowerCase(a)){
                answer += (char)((a - 'a' + n) % 26 + 'a');
            } else if(Character.isUpperCase(a)){
                answer += (char)((a - 'A' + n) % 26 + 'A');
            } else {
                answer += a;
            }
        }
        return answer;
    }
}