class Solution {
    public long solution(int price, int money, int count) {
        long totalCnt = ((long)price + price*count)*count/2;
        return totalCnt > money ? totalCnt - money : 0;
    }
}