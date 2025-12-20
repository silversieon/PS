class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i=0; i<t.length()-p.length()+1; i++){
            long a = Long.parseLong(p);
            long b = Long.parseLong(t.substring(i, i+p.length()));
            answer += a >= b ? 1 : 0;
        }
        return answer;
    }
}