class Solution {
    public int solution(int n) {
        String result = "";
        while(n>0){
            result += n % 3;
            n /= 3;
        }
        return Integer.parseInt(result, 3);
    }
}