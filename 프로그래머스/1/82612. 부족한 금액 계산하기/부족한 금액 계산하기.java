class Solution {
    public long solution(long price, long money, long count) {
        return Math.max(((price + price*count)*count/2) - money, 0);
    }
}