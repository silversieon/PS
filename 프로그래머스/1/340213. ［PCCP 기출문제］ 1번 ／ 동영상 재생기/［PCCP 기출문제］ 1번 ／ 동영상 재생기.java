class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // video_len 및 모든 값을 초로 나타내기, video_len 범위를 벗어나지 못 함
        // pos 위치에서 commands를 순회하며 명령을 수행하는데, 만약 next 시에 오프닝 구간이면 건너뛰기 수행
        int videoLenSec = toSeconds(video_len);
        int posSec = toSeconds(pos);
        int opStartSec = toSeconds(op_start);
        int opEndSec = toSeconds(op_end);
        
        if (posSec >= opStartSec && posSec <= opEndSec) posSec = opEndSec;
        for(String command : commands) {
            if(command.equals("prev")) posSec = Math.max(0, posSec - 10);
            else posSec = Math.min(videoLenSec, posSec + 10);
            if (posSec >= opStartSec && posSec <= opEndSec) posSec = opEndSec;
        }
        return String.format("%02d:%02d", posSec/60, posSec%60);
    }
    private int toSeconds(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
// 27분