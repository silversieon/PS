import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();
        if(N%2!=0) return 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int k=i; ; k++){
                if(cnt==N) break;
                if(k==N){
                    k=-1;
                    continue;
                }
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
                cnt++;
            }
            if(stack.isEmpty()){
                answer++;
            }
            stack.clear();
        }
        return answer;
    }
}