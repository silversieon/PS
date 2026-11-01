class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // video_len 및 모든 값을 초로 나타내기, video_len 범위를 벗어나지 못 함
        // pos 위치에서 commands를 순회하며 명령을 수행하는데, 만약 next 시에 오프닝 구간이면 건너뛰기 수행
        int videoLenSec = toSeconds(video_len);
        int posSec = toSeconds(pos);
        int opStartSec = toSeconds(op_start);
        int opEndSec = toSeconds(op_end);
        
        for(String command : commands) {
            if (posSec >= opStartSec && posSec <= opEndSec) posSec = opEndSec;
            if(command.equals("prev")) {
                posSec = posSec-10 >= 0 ? posSec-10 : 0;
            } else if (command.equals("next")) {
                posSec = posSec+10 <= videoLenSec ? posSec+10 : videoLenSec;
            }
        }
        if (posSec >= opStartSec && posSec <= opEndSec) posSec = opEndSec;
        return toTime(posSec);
    }
    private int toSeconds(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }
    private String toTime(int sec) {
        String m = String.valueOf(sec/60);
        String s = String.valueOf(sec%60);
        m = m.length() == 1 ? "0"+m : m;
        s = s.length() == 1 ? "0"+s : s;
        return m+":"+s;
    }
}
// 27분