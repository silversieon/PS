import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in_time = new HashMap<>();
        Map<String, Integer> count_table = new TreeMap<>();
        
        // 1. records를 순회하며 IN의 경우 분만 계산해서 in_time에 담기
        // 2. OUT을 만날 경우 OUT분 - IN분 해서 count_table에 삽입
        // 3. 마지막에 in_time에 남은 차량들을 순회하고, 23:59분을 분으로 치환한 OUT분 - IN분으로 count_table에 삽입
        // 4. 차량 번호 순으로 저장되도록 TreeMap을 이용하고 배열에 담아 반환
        
        for(String record : records) {
            String[] row = record.split(" ");
            String[] time = row[0].split(":");
            String car = row[1];
            String type = row[2];
            
            // 시간 값을 분으로 치환
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            //System.out.println(minute);
            
            if(type.equals("IN")) {
                in_time.put(car, minute);
            } else {
                count_table.put(car, count_table.getOrDefault(car, 0) + (minute - in_time.get(car)));
                in_time.remove(car);
            }
        }
        for(String remain_car : in_time.keySet()) {
            int minute = 23*60 + 59;
            count_table.put(remain_car, count_table.getOrDefault(remain_car, 0) + (minute - in_time.get(remain_car)));
        }
        
        int[] answer = new int[count_table.size()];
        int idx = 0;
        for(String car : count_table.keySet()) {
            answer[idx++] = calc(count_table.get(car), fees);
        }
        return answer;
    }
    private int calc(int minute, int[] fees) {
        if (minute <= fees[0]) return fees[1];
        return fees[1] + (int)Math.ceil((double)(minute - fees[0]) /fees[2]) * fees[3];
    }
}