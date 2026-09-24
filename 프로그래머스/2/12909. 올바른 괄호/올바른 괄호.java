class Solution {
    boolean solution(String s) {
        boolean isCorrect = false;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == '(') cnt++;
            if (s.charAt(i) == ')') cnt--;
            if (cnt < 0) break;
        }
        if(cnt == 0) isCorrect = true;
        return isCorrect;
    }
}