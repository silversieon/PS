import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        if(length%2!=0) return 0;
        Stack<String> stack = new Stack<>();
        for(int i=0; i<length; i++){
            int cnt = 0;
            for(int k=i; ; k++){
                if(cnt==length) break;
                if(!stack.isEmpty()){
                    String str = s.substring(k, k+1);
                    if((str.equals("]") && stack.peek().equals("[")) ||  
                        (str.equals(")") && stack.peek().equals("(")) ||
                        (str.equals("}") && stack.peek().equals("{")) ){
                        stack.pop();
                    } else {
                        stack.push(str);
                    }
                } else {
                    stack.push(s.substring(k, k+1));
                }
                cnt++;
                if(k==length-1) k=-1;
            }
            if(stack.isEmpty()){
                answer++;
            }
            stack.clear();
        }
        return answer;
    }
}