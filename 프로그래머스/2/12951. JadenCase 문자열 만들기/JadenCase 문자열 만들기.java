import java.util.*;
class Solution {
    static StringTokenizer st;
    public String solution(String s) {
        String answer = "";
        st = new StringTokenizer(s);
        
        int partStrStart = 0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            int strStart = s.indexOf(str, partStrStart);
            for(int i=partStrStart; i<strStart; i++){
                answer+= " ";
            }
            String upperCase = str.toUpperCase();
            answer += upperCase.substring(0, 1) + upperCase.substring(1, upperCase.length()).toLowerCase();
            partStrStart = answer.length();
        }
        for(int i=partStrStart; i<s.length(); i++){
            answer += " ";
        }
        return answer;
    }
}