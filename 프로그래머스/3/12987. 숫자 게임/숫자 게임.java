import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int j=0;
        for(int i=0; i<A.length; i++) {
            int e = A[i];
            
            while(j < B.length && e >= B[j]) j++;
            if(j == B.length) break;
            else {
                answer++;
                j++;
            }
        }
        return answer;
    }
}
// 53분까지
// 1, 3, 5, 7
// 2, 2, 6, 8