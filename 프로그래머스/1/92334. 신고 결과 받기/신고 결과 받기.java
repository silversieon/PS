import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // HashSet을 담은 List를 만들고, 각 유저가 신고했던 전적을 기록
        // 각 유저별 신고 당한 횟수를 List로 만들어 저장
        // report를 순회하면서 신고자 HashSet에서 피신고자가 없다면 신고 List의 인덱스에 +1
        // 신고 List를 int 배열로 바꾸어 반환
        Map<String, Set<String>> userReportSet = new HashMap<>();
        Map<String, Integer> userReportCount = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            userReportSet.put(id_list[i], new HashSet<String>());
            userReportCount.put(id_list[i], 0);
        }
        for(String r : report) {
            String[] u = r.split(" ");
            if(!userReportSet.get(u[0]).contains(u[1])) {
                userReportCount.put(u[1], userReportCount.getOrDefault(u[1], 0) + 1);
                userReportSet.get(u[0]).add(u[1]);
            }
        }
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            for(String key : userReportSet.get(id_list[i])) {
                if (userReportCount.get(key) >= k) answer[i]++;
            }
        }
        return answer;
    }
}