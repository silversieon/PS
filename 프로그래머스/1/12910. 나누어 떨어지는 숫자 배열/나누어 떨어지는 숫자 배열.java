import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
            .filter(num -> num % divisor == 0 ).toArray();
        if(answer.length == 0 ) return new int[]{-1};
        Arrays.sort(answer);
        return answer;
    }
}