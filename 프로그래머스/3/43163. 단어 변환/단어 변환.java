import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int answer;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = 0;
        
        dfs(begin, target, words, 0);
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            int sameCnt = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    sameCnt++;
                }
            }
            if(sameCnt == begin.length()-1){
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}