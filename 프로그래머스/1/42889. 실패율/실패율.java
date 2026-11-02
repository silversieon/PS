import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 멈춰 있는 사람의 수 저장
        int[] count = new int[N+2];
        for(int s : stages) {
            count[s]++;
        }
        
        // 2. 각 스테이지별 실패율 저장
        double[] fail = new double[N+1];
        int reached = stages.length;
        for(int i=1; i<=N; i++) {
            if (reached == 0) {
                fail[i] = 0;
            } else {
                fail[i] = (double)count[i] / reached;
            }
            reached -= count[i];
        }
        
        // 3. 스테이지별 순서 계산
        Integer[] orders = new Integer[N];
        for(int i=0; i<N; i++) {
            orders[i] = i+1;
        }
        Arrays.sort(orders, (a, b) -> {
            if(fail[a] != fail[b]) return Double.compare(fail[b], fail[a]);
            return a - b;
        });
        
        // 4. int 배열 변환 후 반환
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = orders[i];
        }
        return answer;
    }
}