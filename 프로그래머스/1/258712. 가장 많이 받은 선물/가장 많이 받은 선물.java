import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // HashMap 내부에 이름별 HashMap을 만들기 (누가 누구한테 몇 개 줬는지), 각 이름별 선물 지수를 저장할 HashMap을 만들기
        // 최종 받을 선물 개수 저장할 int 배열 만들기(friends 인덱스 순)
        // gifts를 순회하며 두 HashMap 채우기
        // friends를 순회하며 각 friend가 받을 선물 개수 저장, 마지막에 정렬 후 최대값 반환
        Map<String, Map<String, Integer>> toGiftCount = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            toGiftCount.put(friends[i], new HashMap<>());
            for(int j=0; j<friends.length; j++) {
                if (i!=j) {
                    toGiftCount.get(friends[i]).put(friends[j], 0);
                }
            }
            giftScore.put(friends[i], 0);
        }
        int[] totalGiftCount = new int[friends.length];
        
        for(String gift : gifts) {
            String[] name = gift.split(" ");
            
            Map<String, Integer> map = toGiftCount.get(name[0]);
            map.put(name[1], map.getOrDefault(name[1], 0) + 1);
            giftScore.put(name[0], giftScore.getOrDefault(name[0], 0) + 1);
            giftScore.put(name[1], giftScore.getOrDefault(name[1], 0) - 1);
        }
        
        for(int i=0; i<friends.length; i++) {
            String a = friends[i];
            for(int j=i+1; j<friends.length; j++) {
                String b = friends[j];
                int aTob = toGiftCount.get(a).get(b);
                int bToa = toGiftCount.get(b).get(a);
                if (aTob > bToa) totalGiftCount[i] +=1;
                else if (bToa > aTob) totalGiftCount[j] +=1;
                else {
                    int aScore = giftScore.get(a);
                    int bScore = giftScore.get(b);
                    if (aScore > bScore) totalGiftCount[i] +=1;
                    else if (bScore > aScore) totalGiftCount[j] +=1;
                }
            }
        }
        Arrays.sort(totalGiftCount);
        return totalGiftCount[friends.length-1];
    }
}