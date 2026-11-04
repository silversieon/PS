import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        // moves 배열을 순회하며 값-1(board의 row 인덱스)을 찾음
        // 값-1에서 col을 순회하며 먼저 나오는 값 찾음
        // Stack이 비어있지 않을 때, peek 값과 같으면 Stack에서 pop, result+2
        // peek값과 다르면 Stack에 삽입
        int n = board.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves) {
            for (int k=0; k<n; k++) {
                int doll = board[k][move-1];
                if(doll != 0) {
                    board[k][move-1] = 0;
                    if(!stack.isEmpty() && doll == stack.peek()) {
                        stack.pop();
                        result+=2;
                    } else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        return result;
    }
}