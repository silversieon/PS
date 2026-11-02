import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지 번호, 실패율을 담을 2차원 double 배열 필요
        // 누적 유저 수 저장할 변수 필요
        // stages를 정렬하고, 스테이지별 실패율 계산
        // result를 실패율 내림차순 정렬하고 스테이지 번호를 반환
        double[][] result = new double[N][2];
        for(int i=0; i<N; i++) {
            result[i][0] = (double)i;
        }
        Map<Integer, Integer> userCount = new TreeMap<>();
        for(int i=0; i<stages.length; i++) {
            userCount.put(stages[i], userCount.getOrDefault(stages[i], 0) + 1);
        }
        int prevCount = 0;
        for(Map.Entry<Integer, Integer> e : userCount.entrySet()) {
            if(e.getKey() < N+1) {
                result[e.getKey()-1][1] = (double)e.getValue() / (stages.length - prevCount);
            }
            prevCount += e.getValue();
        }
        Arrays.sort(result, (a, b) -> {
            if (b[1] != a[1]) {
                return Double.compare(b[1], a[1]);
            }
            return Double.compare(a[0], b[0]);
        });
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = (int)result[i][0] + 1;
        }
        return answer;
    }
}