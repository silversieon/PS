import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        // musicinfos를 순회하여 분에 맞게 노래 문자열을 이어붙여 ArrayList 저장 (입력한 순서대로 정렬 보장)
        // LinkedHashMap을 순회하며 기억한 리듬 m이 해당 String 문자열 내부에 있다면
        // 현재 노래의 제목과 재생 시간을 기록한다.
        m = convert(m);
        String answer = "(None)";
        List<String[]> musicList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            int playTime = toMinute(music[1]) - toMinute(music[0]);
            String rythm = convert(music[3]);
            
            int p = playTime;
            while(p > 0) {
                int min = Math.min(p, rythm.length());
                sb.append(rythm.substring(0, min));
                p -= min;
            }
            
            musicList.add(new String[]{music[2], String.valueOf(playTime), sb.toString()});
            sb.setLength(0);
        }

        int maxPlayTime = -1;
        for(String[] music : musicList) {
            if(music[2].indexOf(m) != -1) {
                if (maxPlayTime < Integer.parseInt(music[1])) {
                    answer = music[0];
                    maxPlayTime = Integer.parseInt(music[1]);
                }
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