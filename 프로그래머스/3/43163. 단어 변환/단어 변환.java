class Solution {
    private int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        // 1. words 안에 target이 없는 경우
        if(!isExist(target, words)) return 0;
        
        // 2. words 안에 target이 있는 경우
        dfs(begin, target, words, new boolean[words.length], 0);
        return answer;
    }
    private void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if(differentCount(begin, target) == 1) {
            answer = Math.min(answer, cnt+1);
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            if(!visited[i] && differentCount(begin, words[i]) == 1) {
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt+1);
            }
        }
    }
    private int differentCount(String begin, String word) {
        int count = 0;
        for(int i=0; i<word.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) count++;
        }
        return count;
    }
    private boolean isExist(String target, String[] words) {
        boolean exist = false;
        for (String word : words) {
            if (word.equals(target)) {
                exist = true;
                return exist;
            }
        }
        return exist;
    }
}