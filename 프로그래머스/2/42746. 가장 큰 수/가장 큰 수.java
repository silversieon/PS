import java.util.*;
class Solution {
    public String solution(int[] numbers) {
       String[] arr = new String[numbers.length];
        String answer = "";
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        boolean allZero = true;
        for(int i=0; i<numbers.length; i++) {
            if (!arr[i].equals("0")) allZero = false;
            answer += arr[i];
        }
        return allZero ? "0" : answer;
    }
}