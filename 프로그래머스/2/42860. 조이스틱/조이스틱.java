class Solution {
    public int solution(String name) {
        int answer = 0, move = Integer.MAX_VALUE, n = name.length() - 1;
        
        for(int i=0; i<=n; i++) {
            answer += calc(name.charAt(i));
            
            int next = i;
            while(next+1 <=n && name.charAt(next+1) == 'A') {
                next++;
            }
            
            move = Math.min(move, 2*i +(n - next));
            move = Math.min(move, 2*(n-next) + i);
        }
        return answer + move;
    }
    
    private int calc(char c) {
        return Math.min(c - 'A', Math.abs('Z' - c) + 1);
    }
}