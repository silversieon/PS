import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
       // want: number로 원하는 제품과 수량을 담는 HashMap
        // discount를 10일치 순회하여 제품별 개수를 담음
        // 10일치부터 시작해서 하루씩 증가하며 want: number 개수랑 비교
        // 개수가 정확히 일치하면 answer++
        int answer = 0;
        Map<String, Integer> wantCount = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wantCount.put(want[i], number[i]);
        }
        
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i=0; i<10; i++) {
            discountMap.merge(discount[i], 1, Integer::sum);
        }
        
        for(int i=10; i<=discount.length; i++) {
            boolean canPurchase = true;
            for(Map.Entry<String, Integer> e : wantCount.entrySet()) {
                if (discountMap.get(e.getKey()) == null || discountMap.get(e.getKey()) != e.getValue()) {
                    canPurchase = false;
                    break;
                }
            }
            if(canPurchase) answer++;
            if(i<discount.length) {
                discountMap.merge(discount[i-10], -1, Integer::sum);
                discountMap.merge(discount[i], 1, Integer::sum);   
            }
        }
        return answer;
    }
}

// 27분