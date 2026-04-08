import java.util.*;
class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        Arrays.sort(array);
        for(int i=array.length-1; i>=0; i--){
            if(array[i] >height) answer++;
            else break;
        }
        return answer;
    }
}