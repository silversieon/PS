import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // jobs를 순회하며 번호, 요청 시각, 소요시간 3 요소를 담은 배열을 controller에 저장
        // 현재 시각 을 나타낼 변수를 만들고 작업이 끝날 때마다 증가시킴
        // 각 작업의 반환 시간 = 현재 시각 - 요청 시각
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> waitQ = new PriorityQueue<>((a, b) -> {
            if(a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            } else if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int time=0, idx=0, done=0;
        int total=0;
        
        while(done < n) {
            // 1. 현재 시각까지 도착한 작업을 모두 대기 큐에 삽입
            while(idx<n && time>=jobs[idx][0]) {
                waitQ.add(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            // 2. 대기 작업이 없으면 다음 요청으로 점프
            if(waitQ.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            // 3. 작업 하나 꺼내서 현재 시간, 반환 시간 계산
            int[] task = waitQ.poll();
            time += task[2];
            total += time - task[1];
            done++;
        }
        return total/n;
    }
}