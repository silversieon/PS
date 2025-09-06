class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attaksSize = attacks.length;
        int last = attacks[attaksSize-1][0];
        int maxHealth = health;
        int attackCount = 0;
        int bandingCount = 0;
        for(int i=1; i<=last; i++){
            if(attacks[attackCount][0]==i){
                health-=attacks[attackCount][1];
                attackCount++;
                bandingCount = 0;
                if(health<=0){
                    health=-1;
                    break;
                }
                continue;
            }
            if(bandingCount == bandage[0] -1){
                health+= bandage[1] + bandage[2];
                bandingCount = 0;
            } else {
                health+=bandage[1];
                bandingCount++;
            }
            if(health > maxHealth) health = maxHealth;
        }
        return health;
    }
}