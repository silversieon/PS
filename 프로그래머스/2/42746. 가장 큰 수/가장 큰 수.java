import java.util.*;
class Solution {
    public String solution(int[] numbers) {
       String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString().charAt(0) != '0' ? sb.toString() : "0";
    }
}