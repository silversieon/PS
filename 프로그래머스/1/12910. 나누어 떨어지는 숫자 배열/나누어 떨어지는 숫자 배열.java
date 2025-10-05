import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> temp = new ArrayList<>();
        for(int num : arr){
            if(num%divisor==0) temp.add(num);
        }
        
        if(temp.size() == 0) return new int[]{-1};
        int[] answer = new int[temp.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = temp.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}