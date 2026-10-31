class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // attcks를 순회하며 해당 공격 시간 전까지 체력 회복량을 health에 더함(최대 체력 초과 불가, 연속 회복량도 계산)
        // 마지막에 attack으로 인한 체력 감소 후 다음 순회 진행
        // 체력이 0 이하가 되면 즉시 -1반환
        int maxHealth = health;
        int prevTime = 0;
        for(int[] attack : attacks) {
            int curTime = attack[0];
            int damage = attack[1];
            int healTime = curTime - prevTime;
            health += bandage[1] * healTime + healTime / bandage[0] * bandage[2];
            health = health > maxHealth ? maxHealth : health;
            health -= damage;
            if (health <= 0) return -1;
            prevTime = curTime + 1;
        }
        return health;
    }
}
// 42분