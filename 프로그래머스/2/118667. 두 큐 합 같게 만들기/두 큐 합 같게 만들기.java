import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 1. 두 큐의 원소의 합 구하고, 목표 값 설정 (target)
        // 2. 두 큐의 현재 합을 변수에 따로 저장 (매번 순회X)
        long sum1 = 0, sum2 = 0;
        // 3. 큐 자료구조 2개에 각각 값을 넣으며 1, 2번 값 할당
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        for(int num : queue1) {
            q1.add(num);
            sum1 += num;
        }
        for(int num : queue2) {
            q2.add(num);
            sum2 +=num;
        }
        // 4. target보다 큰 쪽에서 작은쪽으로 값을 주도록 반복 수행
        int count = 0;
        while (sum1 != sum2 ) {
            if (sum1 > sum2) {
                int num1 = q1.poll();
                q2.add(num1);
                sum1 -= num1;
                sum2 += num1;
            } else if (sum2 > sum1) {
                int num2 = q2.poll();
                q1.add(num2);
                sum2 -= num2;
                sum1 += num2;
            }
            count++;
            if (q1.isEmpty() || q2.isEmpty() || count == queue1.length*4) return -1;
        }
        // 5. 두 큐의 값이 target과 같아지면 종료하고 횟수 반환
        return count;
    }
}