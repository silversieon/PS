class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int cnt = 0;
        for(int i=0; i<attacks.length; i++){
            answer = Math.min(answer + (attacks[i][0] - (cnt+1)) * bandage[1] + ((attacks[i][0] - (cnt+1)) / bandage[0]) * bandage[2], health) - attacks[i][1];
            if(answer <= 0) return -1;
            cnt = attacks[i][0];
        }
        return answer;
    }
}