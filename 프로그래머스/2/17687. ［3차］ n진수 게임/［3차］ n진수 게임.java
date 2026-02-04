class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String game = "";
        int count = t*m;
        int num = 0;
        
        while(game.length() < count){
            game += Integer.toString(num++, n).toUpperCase();
        }
        
        for(int i=p-1; i<count; i+=m){
            answer += game.charAt(i);
        }
        return answer;
    }
}