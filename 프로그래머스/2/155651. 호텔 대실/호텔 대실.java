import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        // 입장 시각 기준 오름차순 정렬, 사용 중인 방을 담을 PQ rooms 사용
        // book_time을 순회하며 각 입장 시각과 퇴장 시각을 정수로 치환
        // 방이 비어있지 않으면서 가장 빨리 끝나는 방이 현재 입장 이전에 퇴실했다면 해당 방 비우기
        // 해당 시간 방 입실 시키기
        // 현재 사용 중인 방 개수를 반환
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (String[] bt : book_time) {
            int start = toMinute(bt[0]);
            int end = toMinute(bt[1]);

            if (!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll();
            }
            rooms.offer(end+10);
        }
        return rooms.size();
    }
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}