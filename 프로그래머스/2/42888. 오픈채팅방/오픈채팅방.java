import java.util.*;
class Solution {
    private static final String ENTER_VALUE = "님이 들어왔습니다.";
    private static final String LEAVE_VALUE = "님이 나갔습니다.";
    public String[] solution(String[] record) {
        // record를 순회해서 Change를 확인하여 uid별 최종 닉네임을 HashMap에 담는다
        // record를 순회해서 Enter와 Leave 기준 관리자에게 보이는 문자열을 uid별 최종 닉네임으로 담아 반환한다.
        Map<String, String> nameTable = new HashMap<>();
        
        int msgCount = 0;
        for(String r : record) {
            String[] v = r.split(" ");
            String event = v[0];
            if(event.equals("Enter") || event.equals("Leave")) msgCount++;
            if (event.equals("Enter") || event.equals("Change")) {
                nameTable.put(v[1], v[2]);
            }
        }
        String[] answer = new String[msgCount];
        int idx = 0;
        for(String r : record) {
            String[] v = r.split(" ");
            String event = v[0];
            if(event.equals("Change")) continue;
            
            String name = nameTable.get(v[1]);
            if (event.equals("Enter")) answer[idx++] = name + ENTER_VALUE;
            else if (event.equals("Leave")) answer[idx++] = name + LEAVE_VALUE;
        }
        return answer;
    }
}