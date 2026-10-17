import java.util.*;
class Solution {
    public String solution(int[] numbers) {
       String[] arr = new String[numbers.length];
        String answer = "";
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        for(int i=0; i<numbers.length; i++) {
            answer += arr[i];
        }
        return answer.charAt(0) != '0' ? answer : "0";
    }
}