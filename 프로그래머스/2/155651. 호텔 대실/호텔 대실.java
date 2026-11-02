import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        // 입장 시각 기준 오름차순 정렬
        // book_time을 순회하며 각 입장 시각과 퇴장 시각+10을 정수로 치환하고, 방이 필요할 시 Set<String[]>에 담고, answer++
        // 방이 필요함은 기존 방 Set을 순회하며 범위 내에 있을 시 하나 더 필요. 그렇지 않다면 범위에 포함되지 않는 Set 내용을 제거하고 삽입
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> used = new PriorityQueue<>();
        for (String[] bt : book_time) {
            int start = toMinute(bt[0]);
            int end = toMinute(bt[1]);
            
            if(used.isEmpty()) {
                used.offer(end+10);
                System.out.println(bt[0] + " " + bt[1] + " " + used.size());
                continue;
            }
            if (!used.isEmpty() && used.peek() <= start) {
                used.poll();
            }
            System.out.println(bt[0] + " " + bt[1] + " " + used.size());
            used.offer(end+10);
        }
        return used.size();
    }
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}