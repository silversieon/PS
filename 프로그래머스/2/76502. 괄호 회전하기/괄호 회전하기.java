import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();
        if(N%2!=0) return 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<N; i++){
            for(int k=0; k<N; k++){
                if(!stack.isEmpty()){
                    if((s.charAt(k) == ']' && stack.peek() == '[') ||  
                        (s.charAt(k) == ')'&& stack.peek() == '(') ||
                        (s.charAt(k) == '}'&& stack.peek() == '{' )){
                        stack.pop();
                    } else {
                        stack.push(s.charAt(k));
                    }
                } else {
                    stack.push(s.charAt(k));
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
            char c = s.charAt(0);
            s = s.substring(1, N);
            s += c;
            stack.clear();
        }
        return answer;
    }
}