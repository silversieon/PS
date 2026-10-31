import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. 오늘 날짜 년, 월, 일별로 구분, HashMap에 terms 담기
        // 2. privacies 순회하고, HashMap에서 만료 기간 꺼내서 계산, today를 지났다면 i+1번째를 결과 배열에 담기
        // 3. 결과 배열 정렬 후 반환
        int t_year = Integer.parseInt(today.substring(0, 4));
        int t_month = Integer.parseInt(today.substring(5, 7));
        int t_day = Integer.parseInt(today.substring(8, 10));
        
        Map<Character, Integer> map = new HashMap<>();
        for(String term : terms) {
            map.put(term.charAt(0), Integer.parseInt(term.substring(2, term.length())));
        }
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            int year = Integer.parseInt(privacies[i].substring(0, 4));
            int month = Integer.parseInt(privacies[i].substring(5, 7));
            int day = Integer.parseInt(privacies[i].substring(8, 10));
            char c = privacies[i].charAt(11);
            
            int validMonth = map.get(c);
            month += validMonth % 12;
            if (month > 12) {
                month %= 12;
                year += 1;
            }
            year += validMonth / 12;
            if (year > t_year) continue;
            if (year == t_year && month > t_month) continue;
            if (year == t_year && month == t_month && day > t_day) continue;
            answerList.add(i+1);
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}