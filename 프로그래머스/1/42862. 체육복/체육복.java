import java.util.*;
class Solution {
    // 1. 체육복을 잃어버리지 않은 학생 수만큼 answer++
    // 2. 빌림을 표시할 수 있는 배열을 reserve 크기만큼 할당
    // 3. lost를 순회, reserve의 각 번호를 확인하고, 이하, 이상, 같음이면서 아무에게도 빌려주지 않았을 경우 해당 학생에게 빌림++(빌림 표시 true)
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer += n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] lostCheck = new boolean[lost.length];
        boolean[] reserveCheck = new boolean[reserve.length];
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lostCheck[i] = true;
                    reserveCheck[j] = true;
                    answer++;
                    break;
                }
            }
        }
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(!reserveCheck[j] && !lostCheck[i] && (lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1)) {
                    reserveCheck[j] = true;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}