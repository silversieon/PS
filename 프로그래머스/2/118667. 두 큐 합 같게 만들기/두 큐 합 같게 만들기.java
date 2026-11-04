import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 1. 두 큐를 하나의 배열로 이어 붙이고 투포인터 활용 (논리적 원형 큐)
        // 2. 큐 하나의 합과 전체 합을 따로 변수에 저장
        int n = queue1.length;
        int[] queue = new int[n*2];
        long sum1 = 0, total = 0;
        for (int i=0; i<n; i++) {
            queue[i] = queue1[i];
            queue[i+n] = queue2[i];
            sum1 += queue1[i];
            total += queue1[i] + queue2[i];
        }
        if (total%2!=0) return -1;
        
        long target = total/2;
        int l=0, r=n;
        int count = 0;
        int limit = n*3;
        // 5. 원형 큐 내에서 l과 r 이동하며 합 구하기
        while(count <= limit) {
            if (sum1 == target) return count;
            
            if (sum1 > target) {
                sum1 -= queue[l%(2*n)];
                l++;
            } else {
                sum1 += queue[r%(2*n)];
                r++;
            }
            count++;
        }
        return -1;
    }
}