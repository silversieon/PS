import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 1. arr을 순회하며 ArrayList 자료구조에 삽입
        // 2. 만약 삽입 전 값이 이전 값과 같다면 삽입X
        // 3. ArrayList를 int 배열에 담아 반환
        List<Integer> list = new ArrayList<>();
        int preNum = 10;
        for(int num : arr) {
            if (preNum != num) list.add(num);
            preNum = num;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}