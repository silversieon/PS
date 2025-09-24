class Solution {
    public long solution(int a, int b) {
        long answer = ((long)Math.abs(b - a) + 1) * (a + (long)b) / 2;
        return answer;
    }
}