import java.util.*;
class Solution {
    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    private static final String LEAVE_MESSAGE = "님이 나갔습니다.";
    public String[] solution(String[] record) {
        // record를 순회하며 이벤트마다 name 갱신, 로그 갱신(관리자에게 보이는 uid와 출입 여부)
        // 로그를 순회하며 관리자에게 보여지는 문자열 저장 후 반환
        Map<String, String> nameTable = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        for(String r : record) {
            String[] v = r.split(" ");
            String event = v[0];
            switch(event) {
                case "Enter":
                    nameTable.put(v[1], v[2]);
                    logs.add(new String[]{v[1], ENTER_MESSAGE});
                    break;
                case "Leave":
                    logs.add(new String[]{v[1], LEAVE_MESSAGE});
                    break;
                case "Change":
                    nameTable.put(v[1], v[2]);
                    break;
            }
        }
        String[] answer = new String[logs.size()];
        for(int i=0; i<logs.size(); i++) {
            String[] log = logs.get(i);
            answer[i] = nameTable.get(log[0]) + log[1];
        }
        return answer;
    }
}