import java.util.*;
class Solution {
    private static final int DAY_PER_MONTH = 28;
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. 오늘 날짜 년, 월, 일별로 구분, HashMap에 terms 담기
        // 2. privacies 순회하고, HashMap에서 만료 기간 꺼내서 계산, today를 지났다면 i+1번째를 결과 배열에 담기
        int todayDays = toDays(today);
        
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            int expireDays = toDays(p[0]) + map.get(p[1]) * DAY_PER_MONTH;
            
            if(expireDays <= todayDays) {
                answerList.add(i+1);
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    private int toDays(String date) {
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        return year * 12 * DAY_PER_MONTH + month * DAY_PER_MONTH + day;
    }
}