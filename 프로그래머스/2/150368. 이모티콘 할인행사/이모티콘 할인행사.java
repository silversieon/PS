class Solution {
    private static final int[] rates = {10, 20, 30, 40};
    private int maxPlusCount = 0;
    private int maxSales = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        // dfs를 통해 각 사용자별 이모티콘의 모든 할인율을 거치기
        // 가입 여부와 구매 비용을 저장해두고, 기존 최대 가입자 수와 비교, 같으면 매출액 비교 (가입자 수가 더 크면 매출액도 갱신, 같으면 매출액만 갱신)
        dfs(users, emoticons, new int[emoticons.length], 0);
        return new int[]{maxPlusCount, maxSales};
    }
    private void dfs(int[][] users, int[] emoticons, int[] selected, int idx) {
        if(idx == emoticons.length) {
            int totalPlusCount = 0;
            int totalSales = 0;
            for(int[] user : users) {
                int sales = 0;
                for (int i=0; i<emoticons.length; i++) {
                    if (selected[i] >= user[0]) sales += emoticons[i] * (100 - selected[i]) / 100;
                }
                if (sales >= user[1]) totalPlusCount++;
                else totalSales +=sales;
            }
            if (totalPlusCount > maxPlusCount) {
                maxPlusCount = totalPlusCount;
                maxSales = totalSales;
            } else if (totalPlusCount == maxPlusCount) {
                maxSales = Math.max(maxSales, totalSales);
            }
            return;
        }
        
        for(int rate : rates) {
            selected[idx] = rate;
            dfs(users, emoticons, selected, idx+1);
        }
    }
}