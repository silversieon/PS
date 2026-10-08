import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        
        for(int i=0; i<answers.length; i++){
            if(a[i%a.length]==answers[i]) score[0]++;
            if(b[i%b.length]==answers[i]) score[1]++;
            if(c[i%c.length]==answers[i]) score[2]++;
        }  
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> answer = new ArrayList<>();
        if(max == score[0]) answer.add(1);
        if(max == score[1]) answer.add(2);
        if(max == score[2]) answer.add(3);
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}