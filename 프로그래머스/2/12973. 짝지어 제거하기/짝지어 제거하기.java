import java.util.*;
class Solution
{
    static Stack<String> stack = new Stack<>();
    public int solution(String s)
    {
        int answer = 1;
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.substring(i, i+1));
                continue;
            }
            if(stack.peek().equals(s.substring(i, i+1))){
                stack.pop();
            } else {
                stack.push(s.substring(i, i+1));
            }
        }
        if(!stack.isEmpty()) answer = 0;
        return answer;
    }
}