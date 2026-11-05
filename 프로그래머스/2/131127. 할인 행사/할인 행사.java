import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
       // want: number로 원하는 제품과 수량을 담는 HashMap
        // discount를 10일치 순회하여 제품별 개수를 담음
        // 10일치부터 시작해서 하루씩 증가하며 want: number 개수랑 비교
        // 개수가 정확히 일치하면 answer++
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        Map<String, Integer> window = new HashMap<>();
        for(int i=0; i<discount.length; i++) {
            window.merge(discount[i], 1, (a, b) -> a+b);
            
            if (i>=10) {
                window.merge(discount[i-10], -1, (a, b) -> a+b==0 ? null : a+b);
            }
            
            if(i>=9 && window.equals(wantMap)) answer++;
        }  
        return answer;
    }
}

// 27분