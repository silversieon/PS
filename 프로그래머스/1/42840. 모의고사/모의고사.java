import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] tmp = {0, 0, 0};
        
        for(int i=0; i<answers.length; i++){
            if(a[i%5]==answers[i]) tmp[0]++;
            if(b[i%8]==answers[i]) tmp[1]++;
            if(c[i%10]==answers[i]) tmp[2]++;
        }  
        
        int max = Math.max(tmp[0], Math.max(tmp[1], tmp[2]));
        int size = 0;
        for(int i=0; i<3; i++){
            if(max == tmp[i]) size++;
        }
        int[] answer = new int[size];
        int idx=0;
        for(int i=0; i<3; i++){
            if(max == tmp[i]) answer[idx++] = i+1;
        }
        return answer;
    }
}