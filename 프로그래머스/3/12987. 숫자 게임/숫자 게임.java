import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i=0;
        for(int b : B) {
            if (A[i] < b) i++;
        }
        return i;
    }
}
// 53분까지
// 1, 3, 5, 7
// 2, 2, 6, 8