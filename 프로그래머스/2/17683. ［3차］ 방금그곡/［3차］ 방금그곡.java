import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        // #이 붙은 음은 소문자로 replace 필요
        // musicinfos를 순회하여 분에 맞게 노래 문자열을 이어붙이기.
        // 만약 m을 포함하고 있다면 재생시간을 비교, 더 긴 재생 시간을 가질 경우 정답 교체
        m = convert(m);
        String answer = "(None)";
        int maxPlayTime = -1;
        
        for(String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            int playTime = toMinute(music[1]) - toMinute(music[0]);
            String melody = convert(music[3]);
            
            String played = melody.repeat(playTime/melody.length())
                 + melody.substring(0, playTime%melody.length());
            
            if (played.contains(m) && playTime > maxPlayTime) {
                answer = music[2];
                maxPlayTime = playTime;
            }
        }
        return answer;
    }
    private String convert(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}

//38분까지