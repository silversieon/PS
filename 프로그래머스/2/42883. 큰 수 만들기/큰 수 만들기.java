import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(char c : number.toCharArray()) {
            while(!stack.isEmpty() && k>0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        String answer = "";
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if (k>0) {
                k--;
                continue;
            }
            answer = c + answer;
        }
        return answer;
    }
}