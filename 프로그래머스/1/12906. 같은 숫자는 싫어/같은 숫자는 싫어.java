import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 1. arr을 순회하며 Stack 자료구조에 삽입
        // 2. 만약 삽입 전에 stack.peek()와 숫자가 같다면 continue
        // 3. Stack을 순회하며 크기만큼 배열에 넣고 반환
        Stack<Integer> stack = new Stack<>();
        for(int num : arr) {
            if(!stack.isEmpty() && stack.peek() == num) continue;
            stack.push(num);
        }
        int[] answer = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}