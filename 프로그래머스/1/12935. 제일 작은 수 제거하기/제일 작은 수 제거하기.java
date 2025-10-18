import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        
        int[] answer = new int[arr.length-1];
        Queue<Integer> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(min, num);
            queue.add(num);
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num != min){
                answer[cnt] = num;
                cnt++;
            }
        }
        return answer;
    }
}